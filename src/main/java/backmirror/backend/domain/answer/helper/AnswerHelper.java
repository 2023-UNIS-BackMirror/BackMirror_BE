package backmirror.backend.domain.answer.helper;

import backmirror.backend.domain.answer.domain.Answer;
import backmirror.backend.domain.answer.exception.AnswerNotFound;
import backmirror.backend.domain.answer.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerHelper {

    private final AnswerRepository answerRepository;

    public Answer findById(Long answerId) {
        return answerRepository
                .findById(answerId)
                .orElseThrow(() -> {
                    throw AnswerNotFound.EXCEPTION;
                });
    }
}
