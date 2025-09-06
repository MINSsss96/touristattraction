package com.my.touristAttraction.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShoppingResponse {
    @JsonProperty("contentid")
    private Long id;

    @JsonProperty("title")
    private String name;

    @JsonProperty("areacode")
    private String region;

    @JsonProperty("cat3")
    private String type;

    @JsonProperty("mapy")
    private Double latitude;

    @JsonProperty("mapx")
    private Double longitude;

    @JsonProperty("firstimage")
    private String imageUrl;

    @JsonProperty("overview")
    private String description;
}
