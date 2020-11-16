package com.brasilprev.api.service.authenticate.impl;

import com.brasilprev.api.model.User;
import com.brasilprev.api.model.enums.UserRoles;
import com.brasilprev.api.service.authenticate.GeneratorToken;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class GeneratorTokenImpl implements GeneratorToken {

    private static final Logger log = LoggerFactory.getLogger(GeneratorTokenImpl.class);

    @Value("${security.jwt.key}")
    private String secret;

    @Override
    public String generate(User user, List<UserRoles> userRoles) {
        log.info(" Generating token for the user, {}", user.getName());

        Claims claims = Jwts.claims().setSubject(user.getEmail());
        claims.put("name", user.getName());
        claims.put("auth", user.getRole());

        return Jwts.builder()
            .setClaims(claims)
            .signWith(SignatureAlgorithm.HS512, secret)
            .setExpiration(tomorrow())
            .compact();
    }

    private static Date tomorrow() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        Instant instant = tomorrow.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

}
