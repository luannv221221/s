package com.example.demo_gateway.service;

import org.springframework.stereotype.Service;
import io.jsonwebtoken.*;

import java.util.Date;

@Service
public class JwtUtils {
    public static final String SECRKET_KEY = "DMCSECURITYHHHHDDDDDDDFFFFFFFFFFFFFFFF00000000";
    public void validateToken(final String token) {
        Jwts.parser().setSigningKey(SECRKET_KEY).parseClaimsJws(token);
    }

}
