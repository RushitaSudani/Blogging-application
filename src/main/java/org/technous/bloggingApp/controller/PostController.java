package org.technous.bloggingApp.controller;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.technous.bloggingApp.config.AppConstants;
import org.technous.bloggingApp.dto.PostDTO;
import org.technous.bloggingApp.dto.PostResponse;
import org.technous.bloggingApp.models.Post;
import org.technous.bloggingApp.service.FileService;
import org.technous.bloggingApp.service.PostService;
import org.technous.bloggingApp.util.ApiResponse;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin("http://localhost:3000")
public class PostController {
    @Autowired
    private PostService postService;
//
//    @Autowired
//    private FileService fileService;
//
//    @Value("${project.image}")
//    private String path;

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
//    @GetMapping("/getallpost")
//    public ResponseEntity<List<PostDTO>> getAllpostt()
//    {
//        List<PostDTO> posts=postService.getAllpost();
//        return new ResponseEntity<List<PostDTO>>(posts,HttpStatus.OK);
//    }
    @GetMapping("/getallpost")
    public ResponseEntity<PostResponse> getAllpost(
            @RequestParam(value = "pageNumber",defaultValue = AppConstants.PAGE_NUMBER,required = false) int pageNumber,
            @RequestParam(value = "pageSize",defaultValue = AppConstants.PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir
            )
    {
        PostResponse postResponse=postService.getAllpost(pageNumber,pageSize,sortBy,sortDir);
        return new ResponseEntity<PostResponse>(postResponse,HttpStatus.OK);
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

    //serach

    @GetMapping("search/{sid}")
    public ResponseEntity<List<PostDTO>> searchPostByTitle(@PathVariable("sid") String sid)
    {
        List<PostDTO> listofposts=postService.searchPosts(sid);
        return new ResponseEntity<>(listofposts,HttpStatus.OK);
    }

//
//    @GetMapping("imageupload/{postId}")
//    public ResponseEntity<PostDTO> uploadimage(
//            @RequestParam("image") MultipartFile image,
//            @PathVariable("postId") int postId) throws IOException {
//        PostDTO postDTO=this.postService.getById(postId);
//        String filename=this.fileService.uploadImage(path,image);
//
//        postDTO.setImageName(filename);
//        PostDTO updatedPost = this.postService.updatePost(postDTO,postId);
//
//        return new ResponseEntity<PostDTO>(updatedPost,HttpStatus.OK);
//    }
}
