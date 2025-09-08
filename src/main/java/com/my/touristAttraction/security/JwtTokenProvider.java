package com.my.touristAttraction.security;

import com.my.touristAttraction.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String secretKey;  // application.yml에서 설정한 비밀 키를 주입

    @Value("${jwt.expiration}")
    private long expirationTime;  // 토큰 만료 시간 설정

    // JWT 생성 메소드
    public String generateJwtToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())  // 토큰에 사용자 정보를 담는다
                .setIssuedAt(new Date())  // 발급 시간
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))  // 만료 시간 설정
                .signWith(SignatureAlgorithm.HS256, secretKey)  // 비밀 키로 서명
                .compact();  // 최종적으로 JWT를 생성
    }

    // JWT에서 사용자 이름 (subject)을 추출하는 메소드
    public String getUsernameFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)  // 비밀 키로 토큰을 검증
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // JWT 토큰이 만료되었는지 체크하는 메소드
    public boolean isTokenExpired(String token) {
        return getExpirationDateFromToken(token).before(new Date());
    }

    private Date getExpirationDateFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)  // 비밀 키로 토큰을 검증
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    // JWT 토큰 검증 메소드
    public boolean validateToken(String token, User userDetails) {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
//    private final String SECRET_KEY = "your-secret-key";  // 비밀 키는 안전한 곳에 보관하세요
//
//    // JWT 생성 메소드
//    public String generateJwtToken(User user) {
//        return Jwts.builder()
//                .setSubject(user.getUsername())  // 토큰에 사용자 정보를 담는다
//                .setIssuedAt(new Date())  // 발급 시간
//                .setExpiration(new Date(System.currentTimeMillis() + 86400000))  // 1일 만료
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)  // HS256 알고리즘 사용
//                .compact();  // 최종적으로 JWT를 생성
//    }
//
//    // JWT에서 사용자 이름 (subject)을 추출하는 메소드
//    public String getUsernameFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    // JWT 토큰이 만료되었는지 체크하는 메소드
//    public boolean isTokenExpired(String token) {
//        return getExpirationDateFromToken(token).before(new Date());
//    }
//
//    private Date getExpirationDateFromToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody()
//                .getExpiration();
//    }
//
//    // JWT 토큰 검증 메소드
//    public boolean validateToken(String token, User userDetails) {
//        String username = getUsernameFromToken(token);
//        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
}
