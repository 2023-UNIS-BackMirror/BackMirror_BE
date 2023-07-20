package backmirror.backend.domain.post.dto.response;

import backmirror.backend.domain.post.dto.PostDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PostListResponseDTO {

    private String type;

    private List<PostDTO> postList;
}
