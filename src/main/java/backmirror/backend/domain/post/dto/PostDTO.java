package backmirror.backend.domain.post.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PostDTO {

    @NotNull
    private Long postId;

    @NotNull
    private String type;

    @NotNull
    private List<QnADTO> qnaList;
}
