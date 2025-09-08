package com.my.touristAttraction.repository;

import com.my.touristAttraction.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
