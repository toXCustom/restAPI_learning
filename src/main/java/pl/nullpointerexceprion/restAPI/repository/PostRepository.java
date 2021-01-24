package pl.nullpointerexceprion.restAPI.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.nullpointerexceprion.restAPI.model.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT p FROM Post p")
    List<Post> findAllPosts(Pageable page);
}
