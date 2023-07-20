package backmirror.backend.domain.famous.dto.response;

import backmirror.backend.domain.famous.domain.Famous;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FamousFailResponse {

    private Long id;
    private String name;
    private String contents;
    private String image;

    @Builder
    private FamousFailResponse(Long id, String name, String contents, String image) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.image = image;
    }

    public static FamousFailResponse from(Famous famous) {
        return FamousFailResponse.builder()
                .id(famous.getId())
                .name(famous.getName())
                .contents(famous.getContents())
                .image(famous.getImage())
                .build();
    }
}
