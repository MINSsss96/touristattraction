package com.my.touristAttraction.repository;


import com.my.touristAttraction.entity.Shopping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShoppingRepository  extends JpaRepository<Shopping, Long> {
}
