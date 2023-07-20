package backmirror.backend.domain.user.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import backmirror.backend.global.common.dto.ErrorReason;
import backmirror.backend.global.error.BaseErrorCode;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum UserErrorCode implements BaseErrorCode {
    /* Admin */
    USER_NOT_FOUND(NOT_FOUND, "USER_404_1", "존재하지 않는 어드민입니다."),

    /* Data */
    MISMATCH_CODE(BAD_REQUEST, "USER_400_1", "인증코드가 일치하지 않습니다"),
    INVALID_TOKEN(BAD_REQUEST, "USER_400_2", "인증코드가 일치하지 않습니다"),
    DATA_NOT_FOUND(CONFLICT, "USER_404_2", "존재하지 않는 데이터입니다"),
    DUPLICATE_DATA(CONFLICT, "USER_409_1", "이미 존재하는 데이터입니다"),

    /* REFRESH TOKEN */
    NOT_REFRESH_TOKEN(BAD_REQUEST, "USER_400_5", "리프레시 토큰이 아닙니다"),
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, "USER_404_2", "존재하지 않거나 만료된 리프레시 토큰입니다.");
    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);
    }
}
