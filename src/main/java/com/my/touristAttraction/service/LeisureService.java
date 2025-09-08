package com.my.touristAttraction.service;

import com.my.touristAttraction.entity.Leisure;
import com.my.touristAttraction.repository.LeisureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LeisureService {
    private final LeisureRepository repo;

    public List<Leisure> findAll(){ return repo.findAll(); }

    public Optional<Leisure> findById(Long id){ return repo.findById(id); }

    public Leisure create(Leisure l){ return repo.save(l); }

    public Leisure update(Long id, Leisure updated){
        return repo.findById(id).map(l -> {
            l.setName(updated.getName());
            l.setRegion(updated.getRegion());
            l.setType(updated.getType());
            l.setDescription(updated.getDescription());
            l.setImageUrl(updated.getImageUrl());
            l.setLatitude(updated.getLatitude());
            l.setLongitude(updated.getLongitude());
            return repo.save(l);
        }).orElseThrow(() -> new RuntimeException("Leisure not found: " + id));
    }

    public void delete(Long id){ repo.deleteById(id); }
}
