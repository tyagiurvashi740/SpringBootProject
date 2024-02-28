package com.example.springBootProject.service;

import com.example.springBootProject.exception.PostNotFoundException;
import com.example.springBootProject.exception.UserNotFoundException;
import com.example.springBootProject.models.Post;
import com.example.springBootProject.models.User;

import java.util.List;

public interface PostService {
    void createNewPost(Post post,Integer id) throws UserNotFoundException;
    List<Post> allPosts();
    void deletePost(Integer postId,Integer id) throws UserNotFoundException;
//    List<Post> findPostByUserId(Integer userId) throws UserNotFoundException;
    Post retrievePost(Integer id) throws PostNotFoundException;
    List<User> likedPost(Integer postId,Integer userId) throws Exception;

}
