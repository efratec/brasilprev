package com.brasilprev.api.security.service;

import com.brasilprev.api.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


public interface JwtService {

    String getToken(User user);
    Boolean isValidToken(String token);
    String getUserLogin(String token);

}