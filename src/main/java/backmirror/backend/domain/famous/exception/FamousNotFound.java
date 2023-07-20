package backmirror.backend.domain.famous.exception;

import backmirror.backend.global.error.BaseErrorException;

public class FamousNotFound extends BaseErrorException {

    public static final FamousNotFound EXCEPTION = new FamousNotFound();

    private FamousNotFound() {
        super(FamousErrorCode.FAMOUS_NOT_FOUND);
    }
}
