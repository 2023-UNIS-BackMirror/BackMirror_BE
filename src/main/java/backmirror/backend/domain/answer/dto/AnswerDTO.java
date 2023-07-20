package backmirror.backend.domain.answer.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnswerDTO {

    @NotNull
    private Long questionId;

    @NotNull
    private String answer;
}
