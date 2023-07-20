package backmirror.backend.domain.post.repository;

import backmirror.backend.domain.post.domain.Post;
import backmirror.backend.domain.user.domain.User;
import org.springframework.data.jpa.domain.Specification;

public class PostSpecification {

    public static Specification<Post> equalType(String type) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

    public static Specification<Post> equalUser(User user) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("user"), user);
    }

}
