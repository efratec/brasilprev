package com.brasilprev.api.security.service.impl;

import com.brasilprev.api.model.User;
import com.brasilprev.api.security.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {

    @Value("${security.jwt.expiry}")
    private String expiry;

    @Value("${security.jwt.key}")
    private String key;

    @Override
    public String getToken(User user) {
        return Jwts.builder().setClaims(getClaimsUser(user))
                .setExpiration(tomorrow())
                .signWith(SignatureAlgorithm.HS512, key).compact();
    }

    @Override
    public Boolean isValidToken(String token) {
        try {
            Claims claims = getClaims(token);
            return LocalDateTime.now().isBefore(claims.getExpiration().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getUserLogin(String token) {
        return getClaims(token).getSubject();
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

    private Claims getClaimsUser(User user) {
        Claims claimsUser = Jwts.claims().setSubject(user.getEmail());
        claimsUser.put("id", user.getIdUser());
        claimsUser.put("name", user.getName());
        claimsUser.put("auth", user.getRole());
        return claimsUser;
    }

    private static Date tomorrow() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        Instant instant = tomorrow.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

}
