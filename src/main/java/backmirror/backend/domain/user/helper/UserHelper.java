package backmirror.backend.domain.user.helper;

import backmirror.backend.domain.user.domain.User;
import backmirror.backend.domain.user.dto.KakaoUserInfo;
import backmirror.backend.domain.user.exception.InvalidToken;
import backmirror.backend.domain.user.exception.MismatchCode;
import backmirror.backend.domain.user.mapper.UserMapper;
import backmirror.backend.domain.user.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserHelper {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id}")
    private String KAKAO_CLIENT_ID;

    @Value("${spring.security.oauth2.client.registration.kakao.redirect-uri}")
    private String KAKAO_REDIRECT_URI;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public String getAccessToken(String code) {
        // HTTP Header 생성
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        // HTTP Body 생성
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", KAKAO_CLIENT_ID);
        body.add("redirect_uri", KAKAO_REDIRECT_URI);
        body.add("code", code);

        // HTTP 요청 보내기 - Post 방식
        // response 변수의 응답 받음
        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(body, headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        // HTTP 응답 (JSON) -> 액세스 토큰 파싱
        String responseBody = response.getBody();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            return jsonNode.get("access_token").asText();
        } catch (Exception e) {
            throw MismatchCode.EXCEPTION;
        }

    }

    // 토큰으로 카카오 API 호출
    public KakaoUserInfo getUserInfo(String accessToken) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest = new HttpEntity<>(headers);
        RestTemplate rt = new RestTemplate();
        ResponseEntity<String> response = rt.exchange(
                "https://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        String responseBody = response.getBody();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseBody);
            String email = jsonNode.get("kakao_account").get("email").asText();
            String name = jsonNode.get("kakao_account").get("profile").get("nickname").asText();

            return new KakaoUserInfo(email, name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw InvalidToken.EXCEPTION;
        }
    }

    public User registerUserIfNeed(KakaoUserInfo kakaoUserInfo) {

        String kakaoEmail = kakaoUserInfo.getEmail();
        Optional<User> user = userRepository.findByEmail(kakaoEmail);

        if (user.isEmpty()) {
            User newUser = userMapper.toEntity(kakaoUserInfo);
            userRepository.save(newUser);
        }

        return userRepository.findByEmail(kakaoEmail).get();
    }

    //public User
}
