package com.my.touristAttraction.controller;

import com.my.touristAttraction.entity.TouristSpot;
import com.my.touristAttraction.service.TouristSpotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tourist-spots")
@RequiredArgsConstructor
public class TouristSpotController {
    private final TouristSpotService service;

    @GetMapping
    public List<TouristSpot> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<TouristSpot> get(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TouristSpot> create(@RequestBody TouristSpot t){ return ResponseEntity.ok(service.create(t)); }

    @PutMapping("/{id}")
    public ResponseEntity<TouristSpot> update(@PathVariable Long id, @RequestBody TouristSpot t){ return ResponseEntity.ok(service.update(id, t)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
