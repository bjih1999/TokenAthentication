package me.jihyun.tokenlogin.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import me.jihyun.tokenlogin.config.AppProperties;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final AppProperties appProperties;

    public boolean verifyToken(String token) {
        try {
            Jwts.parser().setSigningKey(appProperties.getJwtSecret()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUserId(String token) {
        Claims claims = Jwts.parser().setSigningKey(appProperties.getJwtSecret()).parseClaimsJws(token).getBody();

        return claims.getSubject();
    }
}
