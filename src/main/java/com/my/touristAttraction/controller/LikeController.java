package com.my.touristAttraction.controller;

import com.my.touristAttraction.entity.Like;
import com.my.touristAttraction.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService service;

    @GetMapping
    public List<Like> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Like> get(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Like> create(@RequestBody Like like){ return ResponseEntity.ok(service.create(like)); }

    @PutMapping("/{id}")
    public ResponseEntity<Like> update(@PathVariable Long id, @RequestBody Like like){ return ResponseEntity.ok(service.update(id, like)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
