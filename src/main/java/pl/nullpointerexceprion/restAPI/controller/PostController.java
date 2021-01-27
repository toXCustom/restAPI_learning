package pl.nullpointerexceprion.restAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
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
    public List<PostDto> getPost(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return mapToPostDtos(postService.getPosts(pageNumber, sortDirection));
    }

    @GetMapping("/posts/comments")
    public List<Post> getPostWithComments(@RequestParam(required = false) Integer page, Sort.Direction sort){
        int pageNumber = page != null && page >= 0 ? page : 0;
        Sort.Direction sortDirection = sort != null ? sort : Sort.Direction.ASC;
        return postService.getPostsWithComments(pageNumber, sortDirection);
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        return postService.getSinglePost(id);
    }

    @PostMapping("/posts")
    public Post addPost(@RequestBody Post post) {
         return postService.addPost(post);
    }

    @PutMapping("/posts")
    public Post editPost(@RequestBody Post post) {
        return postService.editPost(post);
    }

    @DeleteMapping("/posts/{id}")
    public void deletePost(@PathVariable long id) {
        postService.deletePost(id);
    }
}
