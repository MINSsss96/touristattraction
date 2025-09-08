package com.my.touristAttraction.controller;

import com.my.touristAttraction.entity.Accommodation;
import com.my.touristAttraction.service.AccommodationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accommodations")
@RequiredArgsConstructor
public class AccommodationController {
    private final AccommodationService service;

    @GetMapping
    public List<Accommodation> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> get(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Accommodation> create(@RequestBody Accommodation a){ return ResponseEntity.ok(service.create(a)); }

    @PutMapping("/{id}")
    public ResponseEntity<Accommodation> update(@PathVariable Long id, @RequestBody Accommodation a){ return ResponseEntity.ok(service.update(id, a)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
