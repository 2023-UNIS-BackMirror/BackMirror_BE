package backmirror.backend.domain.question.service;

import backmirror.backend.domain.question.domain.Question;
import backmirror.backend.domain.question.dto.QuestionDTO;
import backmirror.backend.domain.question.dto.response.QuestionListResponseDTO;
import backmirror.backend.domain.question.repository.QuestionRepository;
import backmirror.backend.domain.question.repository.QuestionSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionListResponseDTO getQuestionList(String type) {
        Specification<Question> spec = ((root, query, criteriaBuilder) -> null);
        spec = spec.and(QuestionSpecification.equalType(type));

        List<Question> questionList = questionRepository.findAll(spec);
        List<QuestionDTO> questionDTOList = new ArrayList<>();

        for(Question question : questionList) {
            Long questionId = question.getId();
            String questionContents = question.getContents();

            questionDTOList.add(
                    new QuestionDTO(questionId, questionContents)
            );
        }

        return new QuestionListResponseDTO(type, questionDTOList);
    }
}
