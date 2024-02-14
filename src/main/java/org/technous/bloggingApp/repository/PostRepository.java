package org.technous.bloggingApp.repository;

import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.technous.bloggingApp.dto.PostDTO;
import org.technous.bloggingApp.models.Categories;
import org.technous.bloggingApp.models.Post;
import org.technous.bloggingApp.models.User;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
    List<Post> findAllByCategories(Categories categories);
    List<Post> findAllByUser(User user);
    List<Post> findByTitleContaining(String title);

}
