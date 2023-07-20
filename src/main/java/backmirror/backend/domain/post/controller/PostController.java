package backmirror.backend.domain.post.controller;

import backmirror.backend.domain.post.dto.response.PostListResponseDTO;
import backmirror.backend.domain.post.service.PostService;
import backmirror.backend.global.config.user.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/post")
public class PostController {

    private final PostService postService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<PostListResponseDTO> getPostTypeList(
            @PathVariable String type,
            @AuthenticationPrincipal UserDetails userDetails
            ) {
        return ResponseEntity.ok(postService.getPostTypeList(type));
    }


}
