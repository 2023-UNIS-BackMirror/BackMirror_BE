package backmirror.backend.global.error.exception;

import backmirror.backend.global.error.BaseErrorException;
import backmirror.backend.global.error.GlobalErrorCode;

public class TokenValidateException extends BaseErrorException {

    public static final BaseErrorException EXCEPTION = new TokenValidateException();

    private TokenValidateException() { super(GlobalErrorCode.INVALID_AUTH_TOKEN); }
}
