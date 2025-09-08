package com.my.touristAttraction.controller;

import com.my.touristAttraction.entity.Leisure;
import com.my.touristAttraction.service.LeisureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leisure")
@RequiredArgsConstructor
public class LeisureController {
    private final LeisureService service;

    @GetMapping
    public List<Leisure> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Leisure> get(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Leisure> create(@RequestBody Leisure l){ return ResponseEntity.ok(service.create(l)); }

    @PutMapping("/{id}")
    public ResponseEntity<Leisure> update(@PathVariable Long id, @RequestBody Leisure l){ return ResponseEntity.ok(service.update(id, l)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
