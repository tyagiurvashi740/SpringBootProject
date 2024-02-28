package com.example.springBootProject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    private Text caption;
    @NotEmpty
    private String image;
    @NotEmpty
    private String video;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @ManyToOne
    private User user;
    @ManyToMany
    private List<User> likedPost=new ArrayList<>();

}
