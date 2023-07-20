package backmirror.backend.domain.famous.helper;

import backmirror.backend.domain.famous.domain.Famous;
import backmirror.backend.domain.famous.exception.FamousNotFound;
import backmirror.backend.domain.famous.repository.FamousRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FamousHelper {

    private final FamousRepository famousRepository;

    public Famous findById(Long famousId) {
        return famousRepository
                .findById(famousId)
                .orElseThrow(() -> {
                    throw FamousNotFound.EXCEPTION;
                });
    }
}
