package com.my.touristAttraction.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserDetailsService userDetailsService;

    public String authenticateUser(String username, String password) {

        // 1. 사용자 인증
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        authenticationManager.authenticate(authenticationToken);  // 인증 처리

        // 2. 사용자 정보 조회
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // 3. JWT 토큰 생성
        String jwtToken = jwtTokenProvider.generateJwtToken((User) userDetails);

        return jwtToken;  // 클라이언트에게 반환할 JWT 토큰
    }
}
