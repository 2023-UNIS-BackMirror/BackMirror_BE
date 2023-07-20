package backmirror.backend.domain.question.repository;

import backmirror.backend.domain.question.domain.Question;
import org.springframework.data.jpa.domain.Specification;

public class QuestionSpecification {

    public static Specification<Question> equalType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

}
