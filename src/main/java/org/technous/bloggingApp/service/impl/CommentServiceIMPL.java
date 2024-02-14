package org.technous.bloggingApp.service.impl;

import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technous.bloggingApp.dto.CommentDTO;
import org.technous.bloggingApp.dto.PostResponse;
import org.technous.bloggingApp.exception.ResourceNotFoundException;
import org.technous.bloggingApp.models.Comment;
import org.technous.bloggingApp.models.Post;
import org.technous.bloggingApp.repository.CommentRepository;
import org.technous.bloggingApp.repository.PostRepository;
import org.technous.bloggingApp.service.CommentService;

@Service
public class CommentServiceIMPL implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CommentDTO createComment(CommentDTO commentDTO, int postid) {
        Post post=postRepository.findById(postid).orElseThrow(()->new ResourceNotFoundException("not found","postId",postid));
        Comment c1=this.modelMapper.map(commentDTO,Comment.class);
        c1.setPost(post);
        Comment saveComment = commentRepository.save(c1);
        return this.modelMapper.map(saveComment,CommentDTO.class);
    }

    @Override
    public void deleteComment(int cid) {
        Comment id=commentRepository.findById(cid).orElseThrow(()->new ResourceNotFoundException("not found","cid",cid));
        commentRepository.delete(id);

    }
}
