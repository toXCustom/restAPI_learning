package pl.nullpointerexceprion.restAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.nullpointerexceprion.restAPI.model.Post;
import pl.nullpointerexceprion.restAPI.repository.PostRepository;
import pl.nullpointerexceprion.restAPI.service.PostService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPost(){
        return postService.getPosts();
    }

    @GetMapping("/posts/{id}")
    public Post getSinglePost(@PathVariable long id){
        return postService.getSiglePost(id);
    }
}
