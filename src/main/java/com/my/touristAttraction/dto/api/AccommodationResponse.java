package com.my.touristAttraction.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AccommodationResponse {
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

    @JsonProperty("mapy")
    private Double latitude;

    @JsonProperty("mapx")
    private Double longitude;

    @JsonProperty("firstimage")
    private String imageUrl;

    @JsonProperty("overview")
    private String description;

    // roomCount, amenities, price 등은 상세 API에서 추가 가능
}
