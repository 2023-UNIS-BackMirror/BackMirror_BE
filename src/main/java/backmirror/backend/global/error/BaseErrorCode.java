package backmirror.backend.global.error;

import backmirror.backend.global.common.dto.ErrorReason;

public interface BaseErrorCode {
    public ErrorReason getErrorReason();
}
