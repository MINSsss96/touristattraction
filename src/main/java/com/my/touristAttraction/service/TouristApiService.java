package com.my.touristAttraction.service;

import com.my.touristAttraction.dto.api.TouristSpotResponse;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

public class TouristApiService {
    private final String serviceKey = "발급받은키"; // TODO: properties에서 관리 권장
    private final String baseUrl = "http://apis.data.go.kr/B551011/KorService1/areaBasedList1";

    public List<TouristSpotResponse> fetchTouristSpots(int page, int size) {
        String url = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("serviceKey", serviceKey)
                .queryParam("MobileOS", "ETC")
                .queryParam("MobileApp", "TouristApp")
                .queryParam("_type", "json")
                .queryParam("pageNo", page)
                .queryParam("numOfRows", size)
                .toUriString();

        RestTemplate restTemplate = new RestTemplate();

        Map response = restTemplate.getForObject(url, Map.class);
        // TODO: 실제 응답 구조가 { response: { body: { items: { item: [...] }}}} 이므로
        //       JsonNode 또는 커스텀 DTO로 파싱해야 함

        System.out.println(response); // 구조 확인용

        // 여기서는 단순 Map으로 가져왔지만,
        // ObjectMapper로 TouristSpotApiResponse 리스트로 변환 가능

        return List.of(); // 일단 빈 값 리턴
    }
}
