package backmirror.backend.domain.question.exception;

import backmirror.backend.global.error.BaseErrorException;

public class QuestionNotFound extends BaseErrorException {

    public static final QuestionNotFound EXCEPTION = new QuestionNotFound();

    private QuestionNotFound() {
        super(QuestionErrorCode.QUESTION_NOT_FOUND);
    }
}
