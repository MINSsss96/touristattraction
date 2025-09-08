package com.my.touristAttraction.service;

import com.my.touristAttraction.entity.TouristSpot;
import com.my.touristAttraction.repository.TouristSpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TouristSpotService {
    private final TouristSpotRepository repo;

    public List<TouristSpot> findAll(){ return repo.findAll(); }

    public Optional<TouristSpot> findById(Long id){ return repo.findById(id); }

    public TouristSpot create(TouristSpot t){ return repo.save(t); }

    public TouristSpot update(Long id, TouristSpot updated){
        return repo.findById(id).map(t -> {
            t.setName(updated.getName());
            t.setAddress(updated.getAddress());
            t.setPhoneNumber(updated.getPhoneNumber());
            t.setHomepage(updated.getHomepage());
            t.setLatitude(updated.getLatitude());
            t.setLongitude(updated.getLongitude());
            t.setOpeningHours(updated.getOpeningHours());
            t.setClosedDays(updated.getClosedDays());
            t.setEntranceFee(updated.getEntranceFee());
            t.setFacilities(updated.getFacilities());
            t.setServices(updated.getServices());
            t.setImageUrl(updated.getImageUrl());
            t.setDescription(updated.getDescription());
            t.setCategory(updated.getCategory());
            return repo.save(t);
        }).orElseThrow(() -> new RuntimeException("TouristSpot not found: " + id));
    }

    public void delete(Long id){ repo.deleteById(id); }
}
