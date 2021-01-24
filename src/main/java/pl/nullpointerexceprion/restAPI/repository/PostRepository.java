package pl.nullpointerexceprion.restAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.nullpointerexceprion.restAPI.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
