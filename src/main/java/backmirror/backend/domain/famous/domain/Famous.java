package backmirror.backend.domain.famous.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Famous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 255)
    private String name;

    @NotNull
    String contents;

    @Nullable
    private String image;

    // 생성자
    @Builder
    private Famous(String name, String contents, String image) {
        this.name = name;
        this.contents = contents;
        this.image = image;
    }

    public static Famous of() {
        return Famous.builder()
                .name("")
                .contents("")
                .image("")
                .build();
    }
}
