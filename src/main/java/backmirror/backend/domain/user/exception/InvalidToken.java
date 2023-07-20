package backmirror.backend.domain.user.exception;

import backmirror.backend.global.error.BaseErrorException;

public class InvalidToken extends BaseErrorException {

    public static final InvalidToken EXCEPTION = new InvalidToken();

    private InvalidToken() {
        super(UserErrorCode.INVALID_TOKEN);
    }
}
