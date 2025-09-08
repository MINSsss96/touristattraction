package com.my.touristAttraction.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter {
    private final String SECRET_KEY = "your-secret-key";  // JWT 서명 키

    @Override
    protected void doFilterInternal(HttpServletRequest request, FilterChain filterChain) throws ServletException, IOException {

        // 1. Authorization 헤더에서 JWT 토큰 추출
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7); // "Bearer "를 제외한 토큰만 추출

            // 2. JWT 토큰 검증 및 Authentication 설정
            try {
                String username = Jwts.parserBuilder()  // parser() 대신 parserBuilder() 사용
                        .setSigningKey(SECRET_KEY)
                        .build()
                        .parseClaimsJws(token)
                        .getBody()
                        .getSubject();

                // 3. 사용자 인증 정보 설정
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    // 인증된 사용자 정보 설정
                    CustomUserDetails userDetails = new CustomUserDetails(username);
                    CustomAuthenticationToken authenticationToken = new CustomAuthenticationToken(userDetails, null, Collections.emptyList());  // 빈 권한 리스트 전달
                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                }
            } catch (Exception e) {
                logger.error("JWT 인증 실패: ", e);
            }
        }

        filterChain.doFilter(request, response);  // 필터 체인 실행
    }

}
