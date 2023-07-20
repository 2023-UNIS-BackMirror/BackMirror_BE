package backmirror.backend.domain.post.controller;

import backmirror.backend.domain.message.dto.MessageDTO;
import backmirror.backend.domain.post.dto.PostDTO;
import backmirror.backend.domain.post.dto.request.PostSaveRequestDTO;
import backmirror.backend.domain.post.dto.response.PostListResponseDTO;
import backmirror.backend.domain.post.service.PostService;
import backmirror.backend.domain.user.domain.User;
import backmirror.backend.global.config.user.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @PostMapping("")
    public ResponseEntity<MessageDTO> savePost(
            @RequestBody PostSaveRequestDTO postSaveRequestDTO,
            @AuthenticationPrincipal UserDetails userDetails ) {
        return ResponseEntity.ok(postService.savePost(postSaveRequestDTO, userDetails));
    }


    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }


    @GetMapping("/type/{type}")
    public ResponseEntity<PostListResponseDTO> getPostTypeList(
            @PathVariable String type,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(postService.getPostTypeList(type, userDetails));
    }


}
