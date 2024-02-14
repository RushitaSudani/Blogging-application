package org.technous.bloggingApp.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.technous.bloggingApp.dto.CommentDTO;
import org.technous.bloggingApp.service.CommentService;
import org.technous.bloggingApp.util.ApiResponse;
@RestController
@RequestMapping("/api/")
@CrossOrigin("http://localhost:3000")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postid}/createcomment")
    public ResponseEntity<CommentDTO> create(@RequestBody CommentDTO commentDTO, @PathVariable("postid") int postid)
    {
        CommentDTO c1=commentService.createComment(commentDTO,postid);
        return new ResponseEntity<>(c1, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{postid}")
    public ApiResponse delete(@PathVariable("postid") int postid)
    {
        commentService.deleteComment(postid);
        return new ApiResponse("deleted",false);
    }

}
