package backmirror.backend.domain.question.dto.response;

import backmirror.backend.domain.question.dto.QuestionDTO;

import java.util.List;

public class QuestionListResponseDTO {

    private String type;

    private List<QuestionDTO> questionList;
}
