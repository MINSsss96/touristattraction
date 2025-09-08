package com.my.touristAttraction.repository;

import com.my.touristAttraction.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, Long> {
}
