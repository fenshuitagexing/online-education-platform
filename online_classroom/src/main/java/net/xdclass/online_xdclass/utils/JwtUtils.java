package net.xdclass.online_xdclass.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.xdclass.online_xdclass.model.entity.User;

import java.util.Date;

public class JwtUtils {

    private static final long EXPIRE_DATE = 60000 * 60 * 24 * 7;
    private static final String SECRET_KEY = "online_classroom";
    private static final String TOKEN_PREFIX = "ABC";
    private static final String SUBJECT = "SSM Development";

    public static String genJsonWebToken(User user) {

        String token = Jwts.builder().setSubject(SUBJECT)
                    .claim("headshot", user.getHeadshot())
                    .claim("id", user.getId())
                    .claim("name", user.getName())
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DATE))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        token += TOKEN_PREFIX;

        return token;
    }

    public static Claims checkJwt(String token) {

        try {
            final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();
            return claims;
        } catch (Exception e) {
            return null;
        }
    }
}