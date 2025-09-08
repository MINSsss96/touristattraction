package com.my.touristAttraction.service;

import com.my.touristAttraction.entity.Restaurant;
import com.my.touristAttraction.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository repo;

    public List<Restaurant> findAll(){ return repo.findAll(); }

    public Optional<Restaurant> findById(Long id){ return repo.findById(id); }

    public Restaurant create(Restaurant r){ return repo.save(r); }

    public Restaurant update(Long id, Restaurant updated){
        return repo.findById(id).map(r -> {
            r.setName(updated.getName());
            r.setRegion(updated.getRegion());
            r.setType(updated.getType());
            r.setDescription(updated.getDescription());
            r.setImageUrl(updated.getImageUrl());
            r.setLatitude(updated.getLatitude());
            r.setLongitude(updated.getLongitude());
            return repo.save(r);
        }).orElseThrow(() -> new RuntimeException("Restaurant not found: " + id));
    }

    public void delete(Long id){ repo.deleteById(id); }
}
