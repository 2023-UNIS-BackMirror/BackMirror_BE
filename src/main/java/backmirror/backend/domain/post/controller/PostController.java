package backmirror.backend.domain.post.controller;

import backmirror.backend.domain.message.dto.MessageDTO;
import backmirror.backend.domain.post.dto.request.PostSaveRequestDTO;
import backmirror.backend.domain.post.dto.response.PostListResponseDTO;
import backmirror.backend.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("")
    public ResponseEntity<MessageDTO> savePost(@RequestBody PostSaveRequestDTO postSaveRequestDTO) {
        System.out.println("postSaveRequestDTO = " + postSaveRequestDTO);
        return ResponseEntity.ok(postService.savePost(postSaveRequestDTO));
    }



    @GetMapping("/type/{type}")
    public ResponseEntity<PostListResponseDTO> getPostTypeList(@PathVariable String type) {
        return ResponseEntity.ok(postService.getPostTypeList(type));
    }


}
