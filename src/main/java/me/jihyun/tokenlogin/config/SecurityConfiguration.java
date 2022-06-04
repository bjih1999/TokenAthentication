package me.jihyun.tokenlogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors() // cors 설정 적용
                    .and()
                .csrf().disable()   // API 서버이기 때문에 cors 설정으로 csrf 방어 가능
//                .exceptionHandling()
//                .authenticationEntryPoint()
//                    .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeHttpRequests()
                .antMatchers("/**")
                .permitAll()    // 인증이 필요하지 않은 엔드포인트
                .antMatchers("/**")
                .authenticated()    // 인증이 필요한 엔드포인트
                    .and()
                .formLogin()
                .disable()
                .headers()
                .frameOptions()
                .disable()  // 클릭재킹 방지 옵션 disable API 서버에서는 상관 없는 듯
        ;

        return http.build();

    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }
}
