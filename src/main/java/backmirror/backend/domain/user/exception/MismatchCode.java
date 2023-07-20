package backmirror.backend.domain.user.exception;

import backmirror.backend.global.error.BaseErrorException;

public class MismatchCode extends BaseErrorException {

    public static final MismatchCode EXCEPTION = new MismatchCode();

    private MismatchCode() {
        super(UserErrorCode.MISMATCH_CODE);
    }
}
