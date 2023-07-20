package backmirror.backend.domain.famous.exception;

import backmirror.backend.global.error.BaseErrorCode;
import backmirror.backend.global.common.dto.ErrorReason;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum FamousErrorCode implements BaseErrorCode {
    /* Famous */
    FAMOUS_NOT_FOUND(NOT_FOUND, "FAMOUS_404_1", "존재하지 않는 유명인 실패 사례입니다.");

    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);

    }
}
