package backmirror.backend.global.error.exception;

import backmirror.backend.global.error.BaseErrorException;
import backmirror.backend.global.error.GlobalErrorCode;

public class ForbiddenAdminException extends BaseErrorException {

    public static final BaseErrorException EXCEPTION = new ForbiddenAdminException();

    private ForbiddenAdminException() { super(GlobalErrorCode.FORBIDDEN_ADMIN); }
}
