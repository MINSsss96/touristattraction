package com.my.touristAttraction.dto;

import lombok.Data;

@Data
public class ShoppingDto {
    private Long id;
    private String name;
    private String region;
    private String type;
    private String description;
    private String imageUrl;
    private Double latitude;
    private Double longitude;
}
