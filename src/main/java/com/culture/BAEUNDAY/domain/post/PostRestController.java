package com.culture.BAEUNDAY.domain.post;


import com.culture.BAEUNDAY.domain.post.DTO.PostResponse;
import com.culture.BAEUNDAY.utils.ApiUtils;
import com.culture.BAEUNDAY.utils.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostRestController {

    private final PostService postService;


    @GetMapping
    public ResponseEntity<?> findAllPost(@RequestParam(value = "sort") String sort,
                                         @RequestParam(value = "status") String status,
                                         @RequestParam(value = "fee") String fee,
                                         @RequestParam(value = "cursor", required = false) String cursor,
                                         @RequestParam(value = "cursorId", required = false) Long cursorId ) {

        PageResponse<?, PostResponse.FindAllDTO> responseDTO = postService.findAll(sort,status,fee,cursor,cursorId);
        return ResponseEntity.ok(ApiUtils.success(responseDTO));
    }

    @GetMapping("/{postId}")
    public  ResponseEntity<?> findPostById(@PathVariable(name = "postId") Long postId ){
        PageResponse<?, PostResponse.FindByIdDTO> responseDTO = postService.findById(postId);
        return ResponseEntity.ok(ApiUtils.success(responseDTO));

    }


}
