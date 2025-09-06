package com.my.touristAttraction.dto;

import lombok.Data;

@Data
public class TouristSpotDto {
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String homepage;
    private Double latitude;
    private Double longitude;
    private String openingHours;
    private String closedDays;
    private String entranceFee;
    private String facilities;
    private String services;
    private String imageUrl;
    private String description;
    private String category;
}
