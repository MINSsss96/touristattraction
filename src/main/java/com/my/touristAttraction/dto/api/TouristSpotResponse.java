package com.my.touristAttraction.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TouristSpotResponse {
    @JsonProperty("contentid")
    private Long id;

    @JsonProperty("title")
    private String name;

    @JsonProperty("addr1")
    private String address;

    @JsonProperty("tel")
    private String phoneNumber;

    @JsonProperty("homepage")
    private String homepage;

    @JsonProperty("mapy") // 위도
    private Double latitude;

    @JsonProperty("mapx") // 경도
    private Double longitude;

    @JsonProperty("firstimage")
    private String imageUrl;

    @JsonProperty("overview")
    private String description;

    // 카테고리, 운영시간 등은 상세조회 API에서 추가 가능
}
