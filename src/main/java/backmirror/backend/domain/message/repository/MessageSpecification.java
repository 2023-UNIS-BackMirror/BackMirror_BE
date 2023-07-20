package backmirror.backend.domain.message.repository;

import backmirror.backend.domain.message.domain.Message;
import org.springframework.data.jpa.domain.Specification;

public class MessageSpecification {

    public static Specification<Message> equalType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }
}
