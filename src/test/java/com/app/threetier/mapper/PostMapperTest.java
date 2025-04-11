package com.app.threetier.mapper;

import com.app.threetier.domain.PostVO;
import com.app.threetier.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Autowired
    PostService postService;

    @Test
    public void selectTest() {
        List<PostVO> posts = postMapper.selectAll();
        posts.stream().map(PostVO::toString).forEach(log::info);
    }

    @Test
    public void postReadTest() {
        postService.getPostById(1L)
                .map(PostVO::toString)
                .ifPresent(log::info);
    }

    @Test
    public void postUpdateTest() {
        PostVO postVO = new PostVO();
        postVO.setId(1L);
        postVO.setPostTitle("아무거나");
        postVO.setPostContent("아무거나");
        postService.edit(postVO);
    }


}
