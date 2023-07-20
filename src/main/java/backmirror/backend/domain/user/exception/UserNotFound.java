package backmirror.backend.domain.user.exception;

import backmirror.backend.global.error.BaseErrorException;

public class UserNotFound extends BaseErrorException {

    public static final UserNotFound EXCEPTION = new UserNotFound();

    private UserNotFound() {
        super(UserErrorCode.USER_NOT_FOUND);
    }
}