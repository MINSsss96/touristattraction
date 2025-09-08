package com.my.touristAttraction.repository;


import com.my.touristAttraction.entity.TouristSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TouristSpotRepository extends JpaRepository<TouristSpot, Long> {
}
