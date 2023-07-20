package backmirror.backend.domain.answer.exception;

import backmirror.backend.global.error.BaseErrorException;

public class AnswerNotFound extends BaseErrorException {

    public static final AnswerNotFound EXCEPTION = new AnswerNotFound();

    private AnswerNotFound() {
        super(AnswerErrorCode.ANSWER_NOT_FOUND);
    }
}
