package backmirror.backend.domain.user;

import backmirror.backend.domain.user.dto.response.KakaoLoginResponse;
import backmirror.backend.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/oauth")
@Tag(name = "Oauth")
public class UserController {

    private final UserService userService;

    @Operation(summary = "회원가입")
    @GetMapping("/kakao")
    public KakaoLoginResponse kakaoLogin(
            @RequestParam(name = "code") String code
    ) {
        return userService.signIn(code);
    }
}
