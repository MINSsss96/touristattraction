package com.my.touristAttraction.service;

import com.my.touristAttraction.entity.Like;
import com.my.touristAttraction.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;

    public List<Like> findAll(){ return likeRepository.findAll(); }

    public Optional<Like> findById(Long id){ return likeRepository.findById(id); }

    public Like create(Like like){
        like.setCreatedAt(LocalDateTime.now());
        return likeRepository.save(like);
    }

    public Like update(Long id, Like updated){
        return likeRepository.findById(id).map(l -> {
            l.setCreatedAt(updated.getCreatedAt());
            return likeRepository.save(l);
        }).orElseThrow(() -> new RuntimeException("Like not found: " + id));
    }

    public void delete(Long id){ likeRepository.deleteById(id); }
}
