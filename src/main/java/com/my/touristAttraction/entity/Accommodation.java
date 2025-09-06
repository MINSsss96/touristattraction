package com.my.touristAttraction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accommodation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier

    private String name; // Accommodation name
    private String address; // Detailed address
    private String phoneNumber; // Contact number
    private String homepage; // Official website URL

    private Double latitude;
    private Double longitude;

    private Integer roomCount; // Number of rooms
    private String amenities; // Facilities (ex: pool, spa, etc.)
    private String price; // Accommodation fee

    private String imageUrl;
    @Column(length = 2000)
    private String description;

    private String category; // Type (ex: hotel, pension, etc.)
}
