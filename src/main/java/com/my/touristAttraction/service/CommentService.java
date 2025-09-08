package com.my.touristAttraction.service;


import com.my.touristAttraction.entity.CommentEntity;
import com.my.touristAttraction.repository.CommentRepository;
import com.my.touristAttraction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public List<CommentEntity> findAll(){ return commentRepository.findAll(); }

    public Optional<CommentEntity> findById(Long id){ return commentRepository.findById(id); }

    public CommentEntity create(CommentEntity c){
        c.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(c);
    }

    public CommentEntity update(Long id, CommentEntity updated){
        return commentRepository.findById(id).map(c -> {
            c.setContent(updated.getContent());
            c.setLikeCount(updated.getLikeCount());
            c.setUpdatedAt(LocalDateTime.now());
            return commentRepository.save(c);
        }).orElseThrow(() -> new RuntimeException("Comment not found: " + id));
    }

    public void delete(Long id){ commentRepository.deleteById(id); }
}
