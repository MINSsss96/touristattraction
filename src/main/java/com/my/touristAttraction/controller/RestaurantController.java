package com.my.touristAttraction.controller;

import com.my.touristAttraction.entity.Restaurant;
import com.my.touristAttraction.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService service;

    @GetMapping
    public List<Restaurant> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> get(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Restaurant> create(@RequestBody Restaurant r){ return ResponseEntity.ok(service.create(r)); }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> update(@PathVariable Long id, @RequestBody Restaurant r){ return ResponseEntity.ok(service.update(id, r)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
