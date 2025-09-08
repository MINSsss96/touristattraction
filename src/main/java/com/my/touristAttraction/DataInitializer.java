package com.my.touristAttraction;

import com.my.touristAttraction.entity.User;
import com.my.touristAttraction.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.findByUsername("admin").isEmpty()) {
            User admin = User.builder()
                    .uid("admin")
                    .password(passwordEncoder.encode("1111"))
                    .username("관리자")
                    .email("admin@example.com")
                    //.roles(Set.of("ROLE_ADMIN","ROLE_USER"))
                    .roles(Set.of("ROLE_ADMIN"))
                    .enabled(true)
                    .build();
            userRepository.save(admin);
            System.out.println("Admin user created: admin / 1111");
        }
        // 일반 유저 계정
        if(userRepository.findByUsername("user").isEmpty()) {
            User user = User.builder()
                    .uid("user")
                    .password(passwordEncoder.encode("1234"))
                    .username("일반유저")
                    .email("user@example.com")
                    .roles(Set.of("ROLE_USER"))  // 일반 유저니까 ROLE_USER만
                    .enabled(true)
                    .build();
            userRepository.save(user);
            System.out.println("Regular user created: user / 1234");
        }
    }



}
