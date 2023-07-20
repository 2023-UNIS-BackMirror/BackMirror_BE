package backmirror.backend.domain.question.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuestionDTO {

    @NotNull
    private Long id;

    @NotNull
    private String contents;

}
