package backmirror.backend.domain.question.controller;

import backmirror.backend.domain.question.dto.response.QuestionListResponseDTO;
import backmirror.backend.domain.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/question")
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/{type}")
    public ResponseEntity<QuestionListResponseDTO> getQuestionList(@PathVariable String type) {
        System.out.println("type = " + type);
        return ResponseEntity.ok(questionService.getQuestionList(type));
    }
}
