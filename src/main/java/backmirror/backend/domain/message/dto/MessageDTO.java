package backmirror.backend.domain.message.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageDTO {

    @NotNull
    private Long id;

    @NotNull
    private String type;

    @NotNull
    private String contents;
}
