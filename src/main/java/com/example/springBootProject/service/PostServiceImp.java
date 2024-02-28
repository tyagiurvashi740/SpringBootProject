package com.example.springBootProject.service;

import com.example.springBootProject.exception.PostNotFoundException;
import com.example.springBootProject.exception.UserNotFoundException;
import com.example.springBootProject.models.Post;
import com.example.springBootProject.models.User;
import com.example.springBootProject.repository.PostRepository;
import com.example.springBootProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PostServiceImp implements PostService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
   private UserService userService;
    @Autowired
    private PostRepository postRepository;


    @Override
    public void createNewPost(Post post, Integer id) throws UserNotFoundException {
        Optional<User> exist=userRepository.findById(id);
        if(exist.isEmpty()){
            throw new UserNotFoundException("User not found");
        }
        post.setUser(exist.get());
        postRepository.save(post);
    }

    @Override
    public List<Post> allPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post retrievePost(Integer id) throws PostNotFoundException {
        Optional<Post> exist=postRepository.findById(id);
        if(exist.isEmpty()){
            throw new PostNotFoundException("Post Not found");
        }
        return exist.get();


        }

    @Override
    public List<User> likedPost(Integer postId, Integer userId) throws Exception {
       Post postExist=retrievePost(postId);
       User userExist=userService.retrieveById(userId);
       if(postExist.getLikedPost().contains(userExist)){
           postExist.getLikedPost().remove(userExist);

       }else{
           postExist.getLikedPost().add(userExist);
       }
       return postExist.getLikedPost();

    }

    @Override
    public void deletePost(Integer postId,Integer userId) throws UserNotFoundException {
        Optional<Post> exist=postRepository.findById(userId);
        if(exist.isEmpty()){
            throw new UserNotFoundException("You cannot delete other person post");
        }
        if(Objects.equals(exist.get().getUser().getId(), userId)){
         postRepository.deleteById(postId);

        }


    }

//    @Override
//    public List<Post> findPostByUserId(Integer userId) throws UserNotFoundException {
//        Optional<User> exist=userRepository.findById(userId);
//        if(exist.isEmpty()){
//            throw new UserNotFoundException("User not found");
//        }
//        return postRepository.postsByUserId(userId);
//
//
//    }




}
