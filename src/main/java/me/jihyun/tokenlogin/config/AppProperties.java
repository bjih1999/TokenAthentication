package me.jihyun.tokenlogin.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AppProperties {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.accessToken.expire}")
    private int accessTokenExpireDuration;
}
