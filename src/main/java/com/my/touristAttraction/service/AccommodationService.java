package com.my.touristAttraction.service;


import com.my.touristAttraction.entity.Accommodation;
import com.my.touristAttraction.repository.AccommodationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccommodationService {
    private final AccommodationRepository repo;

    public List<Accommodation> findAll(){ return repo.findAll(); }

    public Optional<Accommodation> findById(Long id){ return repo.findById(id); }

    public Accommodation create(Accommodation a){ return repo.save(a); }

    public Accommodation update(Long id, Accommodation updated){
        return repo.findById(id).map(a -> {
            a.setName(updated.getName());
            a.setAddress(updated.getAddress());
            a.setPhoneNumber(updated.getPhoneNumber());
            a.setHomepage(updated.getHomepage());
            a.setLatitude(updated.getLatitude());
            a.setLongitude(updated.getLongitude());
            a.setRoomCount(updated.getRoomCount());
            a.setAmenities(updated.getAmenities());
            a.setPrice(updated.getPrice());
            a.setImageUrl(updated.getImageUrl());
            a.setDescription(updated.getDescription());
            a.setCategory(updated.getCategory());
            return repo.save(a);
        }).orElseThrow(() -> new RuntimeException("Accommodation not found: " + id));
    }

    public void delete(Long id){ repo.deleteById(id); }
}
