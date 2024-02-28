package com.example.springBootProject.repository;

import com.example.springBootProject.exception.UserNotFoundException;
import com.example.springBootProject.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {
//    @Query("select* from post where id=id")
//    List<Post> postsByUserId(Integer id);

}
