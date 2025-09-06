package com.my.touristAttraction.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "shopping")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Shopping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Unique identifier

    private String name; // Facility name
    private String region; // Region
    private String type; // Shopping type (ex: market, department store, etc.)

    @Column(length = 2000)
    private String description;

    private String imageUrl;

    private Double latitude;
    private Double longitude;

}
