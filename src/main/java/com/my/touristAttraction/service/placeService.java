package com.my.touristAttraction.service;

import com.my.touristAttraction.entity.Place;
import com.my.touristAttraction.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class placeService {
    private final PlaceRepository placeRepository;

    public List<Place> findAll(){ return placeRepository.findAll(); }

    public Optional<Place> findById(Long id){ return placeRepository.findById(id); }

    public Place create(Place p){ return placeRepository.save(p); }

    // Update is type-specific; provide generic pass-through or use subclass services.
    public Place update(Long id, Place updated){
        return placeRepository.findById(id).map(p -> {
            // minimal: do nothing generic, recommend using subclass services for field updates
            return placeRepository.save(p);
        }).orElseThrow(() -> new RuntimeException("Place not found: " + id));
    }

    public void delete(Long id){ placeRepository.deleteById(id); }
}
