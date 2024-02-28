package com.example.springBootProject.config;

import com.example.springBootProject.constant.APIConstants;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;


import javax.crypto.SecretKey;
import java.util.Date;

public class JwtProvider {
    private SecretKey key= Keys.hmacShaKeyFor(APIConstants.SECRET_KEY.getBytes());
    public String generate(Authentication auth){
        String jwt= Jwts.builder().setIssuer("urvashi").setIssuedAt(new Date()).
                setExpiration(new Date(new Date().getTime()+86400000)).claim("email",auth.getName()).
                signWith(key).compact();
        return jwt;
    }
}
