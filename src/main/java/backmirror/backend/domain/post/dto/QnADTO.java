package backmirror.backend.domain.post.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QnADTO {

    @NotNull
    private String question;

    @NotNull
    private String answer;
}
