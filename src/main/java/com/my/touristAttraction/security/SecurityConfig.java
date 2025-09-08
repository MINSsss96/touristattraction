package com.my.touristAttraction.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter; // JWT 필터 추가

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
        p.setUserDetailsService(userDetailsService);
        p.setPasswordEncoder(passwordEncoder());
        return p;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // 기본 설정
        http
                .csrf(csrf -> csrf.disable()) // CSRF 비활성화, API에서는 일반적으로 사용하지 않음
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/admin/**").hasRole("ADMIN") // 관리자 API는 관리자 권한만 허용
                        .requestMatchers("/public/**").permitAll() // 공개 API는 모두 허용
                        .requestMatchers(HttpMethod.GET, "/api/**").authenticated() // /api/** 경로는 인증된 사용자만 접근 가능
                        .anyRequest().authenticated() // 나머지 API는 인증된 사용자만 접근
                )
                .formLogin(form -> form
                        .disable()  // 폼 로그인 비활성화
                )
                .oauth2Login(oauth2 -> oauth2
                        .disable()  // OAuth2 로그인 비활성화
                )
                .logout(logout -> logout
                        .disable()  // 로그아웃 비활성화 (API에서는 일반적으로 로그아웃을 구현하지 않음)
                )
                .authenticationProvider(authProvider()) // 사용자 인증 프로바이더 설정
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // JWT 필터를 추가

        return http.build();
    }
}








//    private final CustomUserDetailsService userDetailsService;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider p = new DaoAuthenticationProvider();
//        p.setUserDetailsService(userDetailsService);
//        p.setPasswordEncoder(passwordEncoder());
//        return p;
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//
//        http
//                .csrf(csrf -> csrf.disable()) // CSRF 비활성화, 실제 서비스에서는 주의해야 함
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/css/**", "/js/**", "/images/**", "/login", "/").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .formLogin(form -> form
//                        .loginPage("/login")  // 커스텀 로그인 페이지
//                        .defaultSuccessUrl("/home", true)  // 로그인 성공 후 이동
//                        .permitAll()
//                )
//                .oauth2Login(oauth2 -> oauth2
//                        .loginPage("/login")  // 커스텀 로그인 페이지
//                        .defaultSuccessUrl("/home", true)  // 로그인 성공 후 /home으로 리디렉션
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll()
//                )
//                .authenticationProvider(authProvider());
//
//        return http.build();





//        http
//                .csrf(csrf -> csrf.disable()) // CSRF 비활성화 // 학원 프로젝트 용도(실제 서비스는 CSRF 고려)
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//                        .requestMatchers("/css/**","/js/**","/images/**","/login","/").permitAll()
//                        .anyRequest().authenticated()
//                )
//                // ✅ 기존 formLogin 유지 (내 계정 로그인)
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .defaultSuccessUrl("/admin", true)
//                        .permitAll()
//                )
////                // ✅ OAuth2 로그인 추가 (Spotify 로그인)
////                .oauth2Login(oauth2 -> oauth2
////                        .loginPage("/login") // 같은 로그인 페이지에서 처리
////                        .defaultSuccessUrl("/spotify/callback", true) // 로그인 성공 후 처리할 경로
////                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login?logout")
//                        .permitAll()
//                )
//                .authenticationProvider(authProvider());
//
//        return http.build();
//    }
//
//
//}
