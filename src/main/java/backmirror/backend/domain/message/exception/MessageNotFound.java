package backmirror.backend.domain.message.exception;

import backmirror.backend.global.error.BaseErrorException;

public class MessageNotFound extends BaseErrorException {

    public static final MessageNotFound EXCEPTION = new MessageNotFound();

    private MessageNotFound() {
        super(MessageErrorCode.MESSAGE_NOT_FOUND);
    }
}
