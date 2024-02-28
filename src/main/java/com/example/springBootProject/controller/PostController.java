package com.example.springBootProject.controller;

import com.example.springBootProject.exception.PostNotFoundException;
import com.example.springBootProject.exception.UserNotFoundException;
import com.example.springBootProject.models.Post;
import com.example.springBootProject.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.ServerResponse;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    private PostService postService;
    @PostMapping("/posts/{id}")
    public void createPost(@Valid @RequestBody Post post, @PathVariable Integer id)
            throws UserNotFoundException {
        postService.createNewPost(post,id);


    }
    @GetMapping("/posts")
    public List<Post> findAllPosts() {
       return  postService.allPosts();
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> retrievePost(@PathVariable Integer postId) throws PostNotFoundException {
        return new ResponseEntity<>(postService.retrievePost(postId),HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}/users/{userId}")
    public void deletePost(@PathVariable Integer postId,@PathVariable Integer userId) throws UserNotFoundException{
        postService.deletePost(postId,userId);

    }
//    @GetMapping("/posts/{userId}")
//    public ResponseEntity<List<Post>> allPosts(@PathVariable Integer userId) throws UserNotFoundException {
//        return new ResponseEntity<>(postService.findPostByUserId(userId),HttpStatus.OK);
//
//    }
    @PutMapping("/posts/{postId}/users/{userId}")
    public void likedPosts(@PathVariable Integer postId,@PathVariable Integer userId) throws Exception{
        postService.likedPost(postId,userId);
    }


}
