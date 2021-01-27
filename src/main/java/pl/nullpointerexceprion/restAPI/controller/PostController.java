package pl.nullpointerexceprion.restAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexceprion.restAPI.controller.dto.PostDto;
import pl.nullpointerexceprion.restAPI.model.Post;
import pl.nullpointerexceprion.restAPI.service.PostService;

import java.util.List;

import static pl.nullpointerexceprion.restAPI.controller.PostDtoMapper.mapToPostDtos;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<PostDto> getPost(@RequestParam(required = false) int  page){
        int pageNumber = page >= 0 ? page : 0;
        return mapToPostDtos(postService.getPosts(pageNumber));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostWithComments(@RequestParam(required = false) int  page){
        int pageNumber = page >= 0 ? page : 0;
        return postService.getPostsWithComments(pageNumber);
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        return postService.getSinglePost(id);
    }
}
