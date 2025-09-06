package com.my.touristAttraction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tourist_spot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TouristSpot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier

    private String name; // Tourist spot name
    private String address; // Detailed address
    private String phoneNumber; // Contact number
    private String homepage; // Official website URL

    private Double latitude; // Latitude
    private Double longitude; // Longitude

    private String openingHours; // Operating hours
    private String closedDays; // Regular holidays
    private String entranceFee; // Fee info
    private String facilities; // Facilities info (ex: parking, restroom)
    private String services; // Services info (ex: free WiFi, guide service)

    private String imageUrl; // Representative image
    @Column(length = 2000)
    private String description; // Description

    private String category; // Category (ex: cultural, natural, etc.)
}
