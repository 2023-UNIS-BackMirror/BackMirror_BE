package backmirror.backend.domain.message.exception;

import backmirror.backend.global.common.dto.ErrorReason;
import backmirror.backend.global.error.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum MessageErrorCode implements BaseErrorCode {
    /* Message */
    MESSAGE_NOT_FOUND(NOT_FOUND, "ANSWER_404_1", "존재하지 않는 응원 메시지입니다.");

    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);

    }
}
