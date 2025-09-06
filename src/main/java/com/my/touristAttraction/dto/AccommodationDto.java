package com.my.touristAttraction.dto;

import lombok.Data;

@Data
public class AccommodationDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String homepage;
    private Double latitude;
    private Double longitude;
    private Integer roomCount;
    private String amenities;
    private String price;
    private String imageUrl;
    private String description;
    private String category;
}
