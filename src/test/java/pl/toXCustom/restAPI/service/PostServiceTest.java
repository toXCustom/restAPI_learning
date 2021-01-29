package pl.toXCustom.restAPI.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import pl.toXCustom.restAPI.model.Post;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WithMockUser
class PostServiceTest {

    @Autowired
    private PostService postService;

    @Test
    void shouldGetSinglePost() {
        //given

        //when
        Post singlePost = postService.getSinglePost(1L);

        //then
        assertThat(singlePost).isNotNull();
        assertThat(singlePost.getId()).isEqualTo(1L);
    }
}