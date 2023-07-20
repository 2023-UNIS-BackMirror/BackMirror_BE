package backmirror.backend.domain.question.dto.response;

import backmirror.backend.domain.question.dto.QuestionDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QuestionListResponseDTO {

    @NotNull
    private String type;

    @NotNull
    private List<QuestionDTO> questionList;
}
