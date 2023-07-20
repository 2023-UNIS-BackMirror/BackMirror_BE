package backmirror.backend.domain.question.controller;

import backmirror.backend.domain.question.dto.response.QuestionListResponseDTO;
import backmirror.backend.domain.question.service.QuestionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
@Tag(name = "Question")
public class QuestionController {

    private final QuestionService questionService;

    @Operation(summary = "해당 타입의 질문 목록 가져오기")
    @GetMapping("/{type}")
    public ResponseEntity<QuestionListResponseDTO> getQuestionList(@PathVariable String type) {
        System.out.println("type = " + type);
        return ResponseEntity.ok(questionService.getQuestionList(type));
    }
}
