package backmirror.backend.domain.post.dto;

import jakarta.validation.constraints.NotNull;

public class QnADTO {

    @NotNull
    private String question;

    @NotNull
    private String answer;
}
