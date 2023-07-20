package backmirror.backend.domain.post.dto.request;

import backmirror.backend.domain.answer.dto.AnswerDTO;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostSaveRequestDTO {

    @NotNull
    private String type;

    private List<AnswerDTO> answerList;

}
