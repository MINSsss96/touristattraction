package com.my.touristAttraction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "leisure")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Leisure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier

    private String name; // Facility name
    private String region; // Region
    private String type; // Leisure type (ex: ski, surfing, etc.)

    @Column(length = 2000)
    private String description;

    private String imageUrl;

    private Double latitude;
    private Double longitude;
}
