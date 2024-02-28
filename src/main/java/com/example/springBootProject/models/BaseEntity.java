package com.example.springBootProject.models;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigInteger;
import java.time.LocalDateTime;

////indicating that it is not an entity to be mapped
//// to a database table on its own, but its attributes
//// will be inherited by other entities
//createdby createdtime updatedtime updatedby jsonignore @Emuneration

@MappedSuperclass
@Data
public class BaseEntity {
    private BigInteger phone_id;
    private BigInteger phoneNumber;
    @CreationTimestamp
    private LocalDateTime createdTime;
    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;




}
