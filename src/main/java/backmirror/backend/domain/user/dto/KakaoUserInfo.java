package backmirror.backend.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KakaoUserInfo {

    private String email;
    private String name;

    @Builder
    public KakaoUserInfo(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public static KakaoUserInfo of(String email, String name) {
        return KakaoUserInfo.builder()
                .email(email)
                .name(name)
                .build();
    }
}
