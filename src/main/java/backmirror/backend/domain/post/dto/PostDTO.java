package backmirror.backend.domain.post.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostDTO {

    @NotNull
    private Long postId;

    @NotNull
    private String type;

    @NotNull
    private String message;

    @NotNull
    private List<QnADTO> qnaList;
}
