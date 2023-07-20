package backmirror.backend.domain.post.service;

import backmirror.backend.domain.answer.domain.Answer;
import backmirror.backend.domain.answer.dto.AnswerDTO;
import backmirror.backend.domain.answer.repository.AnswerRepository;
import backmirror.backend.domain.message.domain.Message;
import backmirror.backend.domain.message.dto.MessageDTO;
import backmirror.backend.domain.message.repository.MessageRepository;
import backmirror.backend.domain.post.domain.Post;
import backmirror.backend.domain.post.dto.PostDTO;
import backmirror.backend.domain.post.dto.QnADTO;
import backmirror.backend.domain.post.dto.request.PostSaveRequestDTO;
import backmirror.backend.domain.post.dto.response.PostListResponseDTO;
import backmirror.backend.domain.post.repository.PostRepository;
import backmirror.backend.domain.post.repository.PostSpecification;
import backmirror.backend.domain.question.domain.Question;
import backmirror.backend.domain.question.repository.QuestionRepository;
import backmirror.backend.domain.user.domain.User;
import backmirror.backend.domain.user.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final MessageRepository messageRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    @Transactional
    public MessageDTO savePost(PostSaveRequestDTO postSaveRequestDTO) {
        String type = postSaveRequestDTO.getType();
        List<AnswerDTO> answerDTOList = postSaveRequestDTO.getAnswerList();

        Long userId = 1L;
        Long messageId = 1L;

        User user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        Message message = messageRepository.findById(messageId).orElseThrow(EntityNotFoundException::new);

        // Save Post
        Post post = Post.builder()
                .user(user)
                .type(type)
                .message(message)
                .createdAt(new Date())
                .build();

        Post savedPost = postRepository.saveAndFlush(post);


        // Save Answers
        for(AnswerDTO answerDTO : answerDTOList) {
            Question question = questionRepository.findById(answerDTO.getQuestionId()).orElseThrow();

            Answer answer = Answer.builder()
                    .post(savedPost)
                    .question(question)
                    .contents(answerDTO.getAnswer())
                    .build();

            answerRepository.saveAndFlush(answer);
        }


        // Return Message
        MessageDTO messageDTO = new MessageDTO(message.getId(), message.getType(), message.getContents());
        return messageDTO;
    }

    public PostListResponseDTO getPostTypeList(String type) {
        Specification<Post> spec = (root, query, criteriaBuilder) -> null;
        spec = spec.and(PostSpecification.equalType(type));

        List<Post> postList = postRepository.findAll(spec);
        List<PostDTO> postDTOList = new ArrayList<>();

        for (Post post : postList) {
            Long postId = post.getId();
            String postType = post.getType();

            List<QnADTO> qnADTOList = new ArrayList<>();

            PostDTO postDTO = new PostDTO(
                    postId, postType, qnADTOList
            );

            postDTOList.add(postDTO);
        }

        return new PostListResponseDTO(type, postDTOList);
    }

}
