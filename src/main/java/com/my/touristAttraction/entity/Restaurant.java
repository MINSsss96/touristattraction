package com.my.touristAttraction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier

    private String name; // Restaurant name
    private String region; // Region
    private String type; // Type (ex: Korean, Japanese, etc.)

    @Column(length = 2000)
    private String description;

    private String imageUrl;

    private Double latitude;
    private Double longitude;
}
