package backmirror.backend.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class KakaoLoginResponse {

    private Long userId;
    private String accessToken;

    @Builder
    private KakaoLoginResponse(Long userId, String accessToken) {
        this.userId = userId;
        this.accessToken = accessToken;
    }

    public static KakaoLoginResponse of(Long userId, String accessToken) {
        return KakaoLoginResponse.builder()
                .userId(userId)
                .accessToken(accessToken)
                .build();
    }
}
