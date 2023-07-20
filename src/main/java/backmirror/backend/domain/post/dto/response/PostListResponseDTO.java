package backmirror.backend.domain.post.dto.response;

import backmirror.backend.domain.post.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostListResponseDTO {

    private String type;

    private List<PostDTO> postList;
}
