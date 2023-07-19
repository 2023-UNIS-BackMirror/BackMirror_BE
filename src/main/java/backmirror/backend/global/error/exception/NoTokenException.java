package backmirror.backend.global.error.exception;

import backmirror.backend.global.error.BaseErrorException;
import backmirror.backend.global.error.GlobalErrorCode;

public class NoTokenException extends BaseErrorException {

    public static final BaseErrorException EXCEPTION = new NoTokenException();

    private NoTokenException() { super(GlobalErrorCode.NO_TOKEN); }
}
