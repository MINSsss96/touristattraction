package com.my.touristAttraction.service;

import com.my.touristAttraction.entity.Shopping;
import com.my.touristAttraction.repository.ShoppingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShoppingService {
    private final ShoppingRepository repo;

    public List<Shopping> findAll(){ return repo.findAll(); }

    public Optional<Shopping> findById(Long id){ return repo.findById(id); }

    public Shopping create(Shopping s){ return repo.save(s); }

    public Shopping update(Long id, Shopping updated){
        return repo.findById(id).map(s -> {
            s.setName(updated.getName());
            s.setRegion(updated.getRegion());
            s.setType(updated.getType());
            s.setDescription(updated.getDescription());
            s.setImageUrl(updated.getImageUrl());
            s.setLatitude(updated.getLatitude());
            s.setLongitude(updated.getLongitude());
            return repo.save(s);
        }).orElseThrow(() -> new RuntimeException("Shopping not found: " + id));
    }

    public void delete(Long id){ repo.deleteById(id); }
}
