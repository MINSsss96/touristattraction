package com.my.touristAttraction.controller;

import com.my.touristAttraction.entity.Shopping;
import com.my.touristAttraction.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shopping")
@RequiredArgsConstructor
public class ShoppingController {
    private final ShoppingService service;

    @GetMapping
    public List<Shopping> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Shopping> get(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Shopping> create(@RequestBody Shopping s){ return ResponseEntity.ok(service.create(s)); }

    @PutMapping("/{id}")
    public ResponseEntity<Shopping> update(@PathVariable Long id, @RequestBody Shopping s){ return ResponseEntity.ok(service.update(id, s)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
