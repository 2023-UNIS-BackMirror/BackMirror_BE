package backmirror.backend.domain.user.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import backmirror.backend.domain.user.domain.User;
import backmirror.backend.domain.user.exception.UserNotFound;
import backmirror.backend.domain.user.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserHelper {

    private final UserRepository userRepository;

    public User findUser(Long userId) {
        return userRepository
                .findById(userId)
                .orElseThrow(() -> {
                    throw UserNotFound.EXCEPTION;
                });
    }
}
