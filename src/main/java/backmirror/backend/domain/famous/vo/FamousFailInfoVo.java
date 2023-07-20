package backmirror.backend.domain.famous.vo;

import backmirror.backend.domain.famous.domain.Famous;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FamousFailInfoVo {

    private Long id;
    private String name;
    private String contents;
    private String image;

    @Builder
    private FamousFailInfoVo(Long id, String name, String contents, String image) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.image = image;
    }

    public static FamousFailInfoVo from(Famous famous) {
        return FamousFailInfoVo.builder()
                .id(famous.getId())
                .name(famous.getName())
                .contents(famous.getContents())
                .image(famous.getImage())
                .build();
    }
}
