package backmirror.backend.domain.famous.vo;

import backmirror.backend.domain.famous.domain.Famous;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FamousFailBriefInfoVo {

    private Long id;
    private String name;
    private String contents;
    private String image;

    @Builder
    private FamousFailBriefInfoVo(Long id, String name, String contents, String image) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.image = image;
    }

    public static FamousFailBriefInfoVo from(Famous famous) {
        return FamousFailBriefInfoVo.builder()
                .id(famous.getId())
                .name(famous.getName())
                .contents(famous.getContents())
                .image(famous.getImage())
                .build();
    }
}
