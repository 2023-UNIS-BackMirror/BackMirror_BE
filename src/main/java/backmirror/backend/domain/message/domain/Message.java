package backmirror.backend.domain.message.domain;

import backmirror.backend.domain.post.domain.Post;
import backmirror.backend.domain.question.domain.Question;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String type;

    @NotNull
    @Column
    private String contents;

}
