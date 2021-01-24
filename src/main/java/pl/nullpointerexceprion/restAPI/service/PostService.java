package pl.nullpointerexceprion.restAPI.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.nullpointerexceprion.restAPI.model.Post;
import pl.nullpointerexceprion.restAPI.repository.PostRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getSiglePost(long id) {
        return postRepository.findById(id)
                .orElseThrow();
    }
}
