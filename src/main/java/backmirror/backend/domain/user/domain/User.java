package backmirror.backend.domain.user.domain;

import backmirror.backend.domain.user.dto.KakaoUserInfo;
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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 30)
    private String name;

    // 생성자
    @Builder
    private User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public static User of(KakaoUserInfo kakaoUserInfo) {
        return User.builder()
                .email(kakaoUserInfo.getEmail())
                .name(kakaoUserInfo.getName())
                .build();
    }
}
