package me.jihyun.tokenlogin.auth;

import lombok.RequiredArgsConstructor;
import me.jihyun.tokenlogin.config.AppProperties;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class AccessTokenAuthenticationFilter extends OncePerRequestFilter {

    private final AppProperties appProperties;

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String accessToken = getJwtFromRequest(request);
        if (StringUtils.hasText(accessToken) && jwtTokenProvider.verifyToken(accessToken)) {
            String userId = jwtTokenProvider.getUserId(accessToken);

            if (StringUtils.hasText(userId)) {
                UserDetails =
            }
        }
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerTokenPrefix = "Bearer ";
        String bearerToken = request.getHeader("Authorization");
        if (!bearerToken.isEmpty() && bearerToken.startsWith(bearerTokenPrefix)) {
            return bearerToken.substring(bearerTokenPrefix.length());
        }
        return null;
    }
}
