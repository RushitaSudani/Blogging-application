package org.technous.bloggingApp.service.impl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.technous.bloggingApp.dto.PostDTO;
import org.technous.bloggingApp.dto.UserDTO;
import org.technous.bloggingApp.exception.ResourceNotFoundException;
import org.technous.bloggingApp.models.Categories;
import org.technous.bloggingApp.models.Post;
import org.technous.bloggingApp.models.User;
import org.technous.bloggingApp.repository.CategoryRepository;
import org.technous.bloggingApp.repository.PostRepository;
import org.technous.bloggingApp.repository.UserRepository;
import org.technous.bloggingApp.service.PostService;


import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceIMPL implements PostService {
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public PostDTO createPost(PostDTO postDTO,int userId,int categoryId) {
        User u1=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("not found user","userId",userId));
        Categories c1=categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("resource not found","categogyId",categoryId));
        Post post=this.modelMapper.map(postDTO,Post.class);
        post.setImageName("default.png");
       // post.setAddedDate(new Date());
        post.setUser(u1);
        post.setCategories(c1);

        Post newpost=postRepository.save(post);
        return this.modelMapper.map(newpost,PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, int postId) {
        Post post=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("post not found","postId",postId));
        post.setContent(postDTO.getContent());
        post.setTitle(postDTO.getTitle());
        post.setImageName(postDTO.getImageName());
        post.setAddedDate((Date) postDTO.getAddedDate());
       // post.setCategories(postDTO.getCategories());
        Post postDTO1=postRepository.save(post);
        return this.modelMapper.map(postDTO1,PostDTO.class);
    }

    @Override
    public void deletePost(int postId) {
        Post post=postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post not found","postId",postId));
        this.postRepository.delete(post);

    }

    @Override
    public List<PostDTO> getAllpost() {
        List<Post> posts=this.postRepository.findAll();
        List<PostDTO> postDTOS=posts.stream().map((post)->modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public PostDTO getById(int postId) {
        Post postDTO=postRepository.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("post not found","postId",postId));
        return this.modelMapper.map(postDTO,PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostByCategory(int categoryId) {
        Categories categories=categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException("category not found","categoryId",categoryId));
        List<Post> listcategory = this.postRepository.findAllByCategories(categories);
        List<PostDTO> postDTOS=listcategory.stream().map((post)->modelMapper.map(post,PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }

    @Override
    public List<PostDTO> getPostByUser(int userId) {
        User user=userRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User not Found","userId",userId));
        List<Post> userlist=postRepository.findAllByUser(user);
        List<PostDTO> postDTOS=userlist.stream().map((post)->modelMapper.map(post, PostDTO.class)).collect(Collectors.toList());
        return postDTOS;
    }
    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
