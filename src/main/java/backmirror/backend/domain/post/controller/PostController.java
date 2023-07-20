package backmirror.backend.domain.post.controller;

import backmirror.backend.domain.message.dto.MessageDTO;
import backmirror.backend.domain.post.dto.PostDTO;
import backmirror.backend.domain.post.dto.request.PostSaveRequestDTO;
import backmirror.backend.domain.post.dto.response.PostListResponseDTO;
import backmirror.backend.domain.post.service.PostService;
import backmirror.backend.domain.user.domain.User;
import backmirror.backend.global.config.user.UserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Tag(name = "Post")
public class PostController {

    private final PostService postService;

    @Operation(summary = "실패 1건 업로드하기")
    @PostMapping("")
    public ResponseEntity<MessageDTO> savePost(
            @RequestBody PostSaveRequestDTO postSaveRequestDTO,
            @AuthenticationPrincipal UserDetails userDetails ) {
        return ResponseEntity.ok(postService.savePost(postSaveRequestDTO, userDetails));
    }


    @Operation(summary = "실패 1건 열람하기")
    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> getPost(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getPost(postId));
    }

    @Operation(summary = "전체 실패 목록 열람하기")
    @GetMapping("")
    public ResponseEntity<PostListResponseDTO> getPostList(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        return ResponseEntity.ok(postService.getPostList(userDetails));
    }

    @Operation(summary = "특정 타입의 실패 목록 열람하기")
    @GetMapping("/type/{type}")
    public ResponseEntity<PostListResponseDTO> getPostTypeList(
            @PathVariable String type,
            @AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(postService.getPostTypeList(type, userDetails));
    }


}
