package com.my.touristAttraction.controller;


import com.my.touristAttraction.dto.CommentDto;
import com.my.touristAttraction.entity.CommentEntity;
import com.my.touristAttraction.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService service;

    @GetMapping
    public List<CommentEntity> all() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentEntity> get(@PathVariable Long id) {
        return service.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CommentEntity> create(@RequestBody CommentEntity c) {
        return ResponseEntity.ok(service.create(c));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentEntity> update(@PathVariable Long id, @RequestBody CommentEntity c) {
        return ResponseEntity.ok(service.update(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
    // 댓글 작성
//    @PostMapping("/{songId}")
//    public ResponseEntity<CommentDto> createComment(
//            @PathVariable Long songId,
//            @RequestParam Long userId,
//            @RequestParam String content,
//            @RequestParam(required = false) Long parentId) {
//        return ResponseEntity.ok(
//                commentService.createComment(songId, userId, content, parentId)
//        );
//    }
//
//    // 곡별 댓글 조회
//    @GetMapping("/{songId}")
//    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long songId) {
//        return ResponseEntity.ok(commentService.getCommentsBySong(songId));
//    }

//    // 댓글 수정
//    @PutMapping("/{commentId}")
//    public ResponseEntity<CommentDto> updateComment(
//            @PathVariable Long commentId,
//            @RequestParam Long userId,
//            @RequestParam String newContent) {
//        return ResponseEntity.ok(
//                commentService.updateComment(commentId, userId, newContent)
//        );
//    }
//
//    // 댓글 삭제
//    @DeleteMapping("/{commentId}")
//    public ResponseEntity<Void> deleteComment(
//            @PathVariable Long commentId,
//            @RequestParam Long userId) {
//        commentService.deleteComment(commentId, userId);
//        return ResponseEntity.noContent().build();
//    }

