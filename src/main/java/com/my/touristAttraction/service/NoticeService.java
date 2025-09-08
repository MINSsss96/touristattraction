package com.my.touristAttraction.service;

import com.my.touristAttraction.dto.NoticeDto;
import com.my.touristAttraction.entity.Notice;
import com.my.touristAttraction.entity.User;
import com.my.touristAttraction.repository.NoticeRepository;
import com.my.touristAttraction.repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final UserRepository userRepository;

    public List<Notice> findAll(){ return noticeRepository.findAll(); }

    public Optional<Notice> findById(Long id){ return noticeRepository.findById(id); }

    public Notice create(Notice notice){
        notice.setCreatedAt(LocalDateTime.now());
        return noticeRepository.save(notice);
    }

    public Notice update(Long id, Notice updated){
        return noticeRepository.findById(id).map(n -> {
            n.setTitle(updated.getTitle());
            n.setContent(updated.getContent());
            n.setUpdatedAt(LocalDateTime.now());
            return noticeRepository.save(n);
        }).orElseThrow(() -> new RuntimeException("Notice not found: " + id));
    }

    public void delete(Long id){ noticeRepository.deleteById(id); }

    // 공지사항 리스트 (페이징 지원)
    public Page<Notice> listNotices(int page, int size) {
        return noticeRepository.findAll(PageRequest.of(page, size));
    }

    public void createNotice(@Valid NoticeDto dto, String username) {
    }

    public Notice getNotice(Long id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found with id: " + id));
    }

    public void updateNotice(Long id, @Valid NoticeDto dto) {
    }

    public void deleteNotice(Long id) {

    }

//    public Page<Notice> listNotices(int page, int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
//        return noticeRepository.findAllByOrderByCreatedAtDesc(pageable);
//    }
//
//    public Notice getNotice(Long id) {
//        return noticeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("공지사항을 찾을 수 없습니다"));
//    }
//
//    public Notice createNotice(NoticeDto dto, String adminUsername) {
//        User admin = userRepository.findByUsername(adminUsername).orElseThrow(() -> new IllegalArgumentException("관리자 계정이 없습니다"));
//        Notice n = Notice.builder()
//                .title(dto.getTitle())
//                .content(dto.getContent())
//                .user(admin)
//                .build();
//        return noticeRepository.save(n);
//    }
//
//    public Notice updateNotice(Long id, NoticeDto dto) {
//        Notice n = getNotice(id);
//        n.setTitle(dto.getTitle());
//        n.setContent(dto.getContent());
//        return noticeRepository.save(n);
//    }
//
//    public void deleteNotice(Long id) {
//        noticeRepository.deleteById(id);
//    }
}
