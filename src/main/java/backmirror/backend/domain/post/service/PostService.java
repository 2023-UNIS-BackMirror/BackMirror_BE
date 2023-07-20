package backmirror.backend.domain.post.service;

import backmirror.backend.domain.post.domain.Post;
import backmirror.backend.domain.post.dto.PostDTO;
import backmirror.backend.domain.post.dto.response.PostListResponseDTO;
import backmirror.backend.domain.post.repository.PostRepository;
import backmirror.backend.domain.post.repository.PostSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public PostListResponseDTO getPostTypeList(String type) {
        Specification<Post> spec = (root, query, criteriaBuilder) -> null;
        spec = spec.and(PostSpecification.equalType(type));

        List<Post> postList = postRepository.findAll(spec);
        List<PostDTO> postDTOList = new ArrayList<>();

        for (Post post : postList) {
            Long postId = post.getId();
            PostDTO postDTO = new PostDTO(
                    post.getId()
            );

            postDTOList.add(postDTO);
        }

        return new PostListResponseDTO(type, postDTOList);
    }

}
