package com.my.touristAttraction.controller;

import com.my.touristAttraction.entity.Notice;
import com.my.touristAttraction.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService service;

    @GetMapping
    public List<Notice> all(){ return service.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Notice> get(@PathVariable Long id){
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Notice> create(@RequestBody Notice n){ return ResponseEntity.ok(service.create(n)); }

    @PutMapping("/{id}")
    public ResponseEntity<Notice> update(@PathVariable Long id, @RequestBody Notice n){ return ResponseEntity.ok(service.update(id, n)); }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
