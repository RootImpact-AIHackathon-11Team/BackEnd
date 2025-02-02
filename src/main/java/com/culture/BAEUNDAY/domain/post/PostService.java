package com.culture.BAEUNDAY.domain.post;


import com.culture.BAEUNDAY.domain.post.DTO.PostResponse;
import com.culture.BAEUNDAY.utils.CursorRequest;
import com.culture.BAEUNDAY.utils.CursorResponse;
import com.culture.BAEUNDAY.utils.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Function;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostJPARepository postJPARepository;
    private static final int PAGE_SIZE_PLUS_ONE = 5 + 1;
    public PageResponse<? extends Comparable<?> , PostResponse.FindAllDTO> findAll(String sort, String status, String fee, String cursor, Long cursorId) {
        List<Post> posts;

        switch( sort ) {
            case "id" -> {
                CursorRequest<Long> page = new CursorRequest(PAGE_SIZE_PLUS_ONE, cursor, Long.class, cursorId );
                posts = postJPARepository.findAllByIdLessThanCursor(page.cursor, page.request);
                return createCursorPageResponse(Post::getId, posts);
            }
            case "heart" -> {
                CursorRequest<Long> page = new CursorRequest(PAGE_SIZE_PLUS_ONE, cursor, Long.class, cursorId );
                posts = postJPARepository.findAllByHeartLessThanCursor(page.cursor, page.cursorID, page.request);
                return createCursorPageResponse(Post::getNumsOfHeart, posts);
            }
            case "recent" -> {
                CursorRequest<LocalDateTime> page = new CursorRequest(PAGE_SIZE_PLUS_ONE, cursor, LocalDateTime.class, cursorId );
                posts = postJPARepository.findAllByDateLessThanCursor( page.cursor, page.cursorID, page.request);
                return createCursorPageResponse(Post::getCreatedDate, posts);
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private <T extends Comparable<T>> PageResponse<T, PostResponse.FindAllDTO> createCursorPageResponse(Function<Post, T> cursorExtractor, List<Post> posts){

        //포스트 정보가 없을 경우
        if (posts.isEmpty()) {
            return new PageResponse<>(new CursorResponse<>(false,0, null, null), List.of());
        }

        int size = posts.size();
        boolean hasNext = false;
        if (size == PAGE_SIZE_PLUS_ONE) { //6개라면, 5개만 전송하고 hasNext를 true로 설정
            posts.remove(size - 1) ;
            size -= 1;
            hasNext = true;
        }

        List<PostResponse.FindAllDTO> findAllDTOS = posts.stream().map(PostResponse.FindAllDTO::new).toList();
        Post lastPost = posts.get(size - 1) ;
        T nextCursor = cursorExtractor.apply(lastPost);
        Long nextCursorId = lastPost.getId();

        return new PageResponse<>(new CursorResponse<>(hasNext, size, nextCursor, nextCursorId), findAllDTOS);

    }
}
