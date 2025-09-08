package com.my.touristAttraction.security;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PublicDataApiClient {
    private static final String API_KEY = "your-api-key";  // 공공데이터 API 키

    public String getPublicData() {
        String apiUrl = "https://api.example.com/data";  // 공공데이터 API 엔드포인트 URL

        // HTTP 헤더에 API Key 추가
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + API_KEY);  // API 키를 Authorization 헤더에 추가

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, entity, String.class);

        return response.getBody();  // 응답 데이터 반환
    }
}
