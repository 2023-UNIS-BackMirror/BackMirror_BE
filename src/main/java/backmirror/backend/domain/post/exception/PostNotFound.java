package backmirror.backend.domain.post.exception;

import backmirror.backend.global.error.BaseErrorException;

public class PostNotFound extends BaseErrorException {

    public static final PostNotFound EXCEPTION = new PostNotFound();

    private PostNotFound() {
        super(PostErrorCode.POST_NOT_FOUND);
    }
}
