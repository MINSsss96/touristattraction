package com.my.touristAttraction.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;


@Configuration
public class OAuth2ClientConfig {
    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(clientRegistration());
    }

    @Bean
    public ClientRegistration clientRegistration() {
        return ClientRegistration.withRegistrationId("spotify")  // 등록 아이디 설정
                .clientId("your-client-id")  // Spotify의 클라이언트 아이디
                .clientSecret("your-client-secret")  // Spotify의 클라이언트 시크릿
                .scope("user-read-private", "user-read-email")  // 요청할 권한(스코프)
                .authorizationUri("https://accounts.spotify.com/authorize")  // Authorization URL
                .tokenUri("https://accounts.spotify.com/api/token")  // Token URL
                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")  // 리디렉션 URI
                .clientName("Spotify")
                .authorizationGrantType(org.springframework.security.oauth2.core.AuthorizationGrantType.AUTHORIZATION_CODE)  // 인증 방식 설정
                .build();
    }

//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        ClientRegistration googleClientRegistration = ClientRegistration.withRegistrationId("google")
//                .clientId("YOUR_GOOGLE_CLIENT_ID")
//                .clientSecret("YOUR_GOOGLE_CLIENT_SECRET")
//                .scope("profile", "email")
//                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
//                .tokenUri("https://oauth2.googleapis.com/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//                .redirectUri("{baseUrl}/login/oauth2/code/{registrationId}")
//                .build();
//
//        // 등록된 클라이언트들을 인메모리로 관리
//        return new InMemoryClientRegistrationRepository(googleClientRegistration);
//    }
//
//    // OAuth2AuthorizedClientService 빈 정의
//    @Bean
//    public OAuth2AuthorizedClientService authorizedClientService(
//            ClientRegistrationRepository clientRegistrationRepository) {
//        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
//    }
////
////    @Bean
////    public OAuth2AuthorizedClientService authorizedClientService(
////           ClientRegistrationRepository clientRegistrationRepository) {
////        return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository);
////    }
}
