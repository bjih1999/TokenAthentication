package me.jihyun.tokenlogin.auth;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import me.jihyun.tokenlogin.config.AppProperties;
import me.jihyun.tokenlogin.member.memberDetails.MemberDetails;
import me.jihyun.tokenlogin.member.memberDetails.MemberDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;

@Component
@RequiredArgsConstructor
public class JwtTokenProvider {

    private final AppProperties appProperties;

    private final MemberDetailsService memberDetailsService;

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
    public Authentication getAuthentication(String token) {
        if (StringUtils.hasText(token) && verifyToken(token)) {
            String userId = getUserId(token);
            MemberDetails memberDetails = memberDetailsService.loadUserByUsername(userId);

            return new UsernamePasswordAuthenticationToken(memberDetails, "", memberDetails.getAuthorities());
        }

        return null;
    }
}
