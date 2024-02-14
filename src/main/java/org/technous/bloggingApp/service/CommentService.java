package org.technous.bloggingApp.service;
import org.technous.bloggingApp.dto.CommentDTO;
import org.technous.bloggingApp.models.Comment;

public interface CommentService {
    public CommentDTO createComment(CommentDTO commentDTO,int postid);
    void deleteComment(int cid);

}
