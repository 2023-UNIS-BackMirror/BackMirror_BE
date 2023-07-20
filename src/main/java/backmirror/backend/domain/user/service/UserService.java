package backmirror.backend.domain.user.service;

import backmirror.backend.domain.user.domain.User;
import backmirror.backend.domain.user.dto.KakaoUserInfo;
import backmirror.backend.domain.user.dto.response.KakaoLoginResponse;
import backmirror.backend.domain.user.helper.UserHelper;
import backmirror.backend.domain.user.mapper.UserMapper;
import backmirror.backend.global.config.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final TokenProvider tokenProvider;
    private final UserHelper userHelper;
    private final UserMapper userMapper;

    @Transactional
    public KakaoLoginResponse signIn(String code) {

        String kakaoAccessToken = userHelper.getAccessToken(code);

        KakaoUserInfo userInfo = userHelper.getUserInfo(kakaoAccessToken);

        User user = userHelper.registerUserIfNeed(userInfo);

        final Authentication authentication = tokenProvider.userAuthorizationInput(user);

        final String accessToken = tokenProvider.generateJwtAccessToken(user.getId(), authentication);

        return userMapper.toKakaoLoginResponse(user.getId(), accessToken);
    }
}
