package org.technous.bloggingApp.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technous.bloggingApp.dto.PostDTO;
import org.technous.bloggingApp.models.Post;
import org.technous.bloggingApp.service.PostService;
import org.technous.bloggingApp.util.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("api/")
public class PostController {
    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@Valid @RequestBody PostDTO postDTO, @PathVariable("userId") int userId, @PathVariable("categoryId") int categoryId)
    {
        PostDTO createpost=this.postService.createPost(postDTO,userId,categoryId);
        return new ResponseEntity<PostDTO>(createpost, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable("userId") int userId)
    {
        List<PostDTO> listuser=postService.getPostByUser(userId);
        return new ResponseEntity<List<PostDTO>>(listuser,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable("categoryId") int categotyId)
    {
        List<PostDTO> listcategory=postService.getPostByCategory(categotyId);
        return new ResponseEntity<List<PostDTO>>(listcategory,HttpStatus.OK);
    }

    //get all post

    @GetMapping("/getallpost")
    public ResponseEntity<List<PostDTO>> getAllpost()
    {
        List<PostDTO> posts=postService.getAllpost();
        return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
    }

    @GetMapping("getbyid/{postId}")
    public PostDTO getPostById(@PathVariable("postId") int postId)
    {
        PostDTO postDTO=postService.getById(postId);
        return postDTO;
    }

    //delete post

    @DeleteMapping("deletepost/{postId}")
    public ApiResponse deleteUser(@PathVariable("postId") int postId)
    {
        this.postService.deletePost(postId);
        return new ApiResponse("Post Deleted",true);
    }

    @PutMapping("updatepost/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO,@PathVariable("postId") int postId)
    {
        PostDTO p1=postService.updatePost(postDTO,postId);
        return new ResponseEntity<PostDTO>(p1,HttpStatus.OK);
    }
}
