package backmirror.backend.domain.famous.repository;

import backmirror.backend.domain.famous.domain.Famous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamousRepository extends JpaRepository<Famous, Long> {

}
