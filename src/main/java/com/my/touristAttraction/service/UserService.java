package com.my.touristAttraction.service;

import com.my.touristAttraction.dto.UserAdminDto;
import com.my.touristAttraction.entity.User;
import com.my.touristAttraction.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User updated) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setUsername(updated.getUsername());
                    u.setAddress(updated.getAddress());
                    u.setNickname(updated.getNickname());
                    u.setPassword(updated.getPassword());
                    u.setEmail(updated.getEmail());
                    u.setRoles(updated.getRoles());
                    u.setEnabled(updated.isEnabled());
                    return userRepository.save(u);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserAdminDto> listAllUsers() {
        return null;
    }

    public void disableUser(Long id) {
    }

    public void enableUser(Long id) {
    }

    public void deleteUser(Long id) {
    }

    public User create(User u) {
        return null;
    }
}
