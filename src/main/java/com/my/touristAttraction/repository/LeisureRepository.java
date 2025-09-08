package com.my.touristAttraction.repository;


import com.my.touristAttraction.entity.Leisure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LeisureRepository extends JpaRepository<Leisure, Long> {
}
