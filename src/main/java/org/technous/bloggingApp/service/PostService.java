package org.technous.bloggingApp.service;

import org.technous.bloggingApp.dto.PostDTO;
import org.technous.bloggingApp.dto.PostResponse;
import org.technous.bloggingApp.models.Categories;
import org.technous.bloggingApp.models.Post;

import java.util.List;

public interface PostService {

    //create
    PostDTO createPost(PostDTO postDTO,int userId,int categoryId);
    PostDTO updatePost(PostDTO postDTO,int postId);
    void deletePost(int postId);
    PostResponse getAllpost(int pageNumber, int pageSize,String sortBy,String sortDir);
    PostDTO getById(int postId);

    //get all post by categories
    List<PostDTO> getPostByCategory(int categoryId);

    //get all post by user
    List<PostDTO> getPostByUser(int userId);

    //search posts
    List<PostDTO> searchPosts(String keyword);


}
