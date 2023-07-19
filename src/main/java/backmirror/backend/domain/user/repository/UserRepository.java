package backmirror.backend.domain.user.repository;

import backmirror.backend.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    public Optional<User> findByNickname(String nickname);

    public Optional<User> findByEmail(String email);
}