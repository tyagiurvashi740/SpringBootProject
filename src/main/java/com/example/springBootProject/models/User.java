package com.example.springBootProject.models;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
//@NoArgsConstructor
//@AllArgsConstructor
//UUId implementation
@Table(name="user")
public class User implements UserDetails {
    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name",length=55)
    @NotBlank
    private String firstName;
    @Column(name="last_name",length=55)
    @NotBlank
    private String lastName;
    @Email
    private String Email;
    @NotEmpty
    private String password;
    @Enumerated(value=EnumType.STRING)
    private Role role;
    @NotNull
    @Column(name="pin_Code")
    private Integer pinCode;
    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
    @UpdateTimestamp
    private Timestamp updatedTimeStamp;
    @Column(name="TAC1")
    @AssertTrue(message="Agree TermAndCondition 1")
    private Boolean termAndCondition1;
    @Column(name="TAC2")
    @AssertTrue(message="Agree TermAndCondition 2")
    private Boolean termAndCondition2;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {

        return firstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
