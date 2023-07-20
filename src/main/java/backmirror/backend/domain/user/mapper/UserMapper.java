package backmirror.backend.domain.user.mapper;

import backmirror.backend.domain.user.domain.User;
import backmirror.backend.domain.user.dto.KakaoUserInfo;
import backmirror.backend.domain.user.dto.response.KakaoLoginResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(KakaoUserInfo kakaoUserInfo) {
        return User.of(kakaoUserInfo);
    }

    public KakaoLoginResponse toKakaoLoginResponse(Long userId, String accessToken) {
        return KakaoLoginResponse.of(userId, accessToken);
    }
}
