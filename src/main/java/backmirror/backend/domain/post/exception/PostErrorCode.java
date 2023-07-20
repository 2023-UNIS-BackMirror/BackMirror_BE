package backmirror.backend.domain.post.exception;

import backmirror.backend.global.common.dto.ErrorReason;
import backmirror.backend.global.error.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum PostErrorCode implements BaseErrorCode {
    /* Post */
    POST_NOT_FOUND(NOT_FOUND, "POST_404_1", "존재하지 않는 실패 기록입니다.");

    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);

    }
}
