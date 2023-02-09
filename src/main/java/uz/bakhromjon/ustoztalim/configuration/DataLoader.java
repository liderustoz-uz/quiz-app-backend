package uz.bakhromjon.ustoztalim.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.entity.User;
import uz.bakhromjon.ustoztalim.enums.ERole;
import uz.bakhromjon.ustoztalim.repository.UserRepository;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Override
    public void run(String... args) {
        if (ddl.contains("create")) {
            User user = new User("Bakhromjon", "Khasanboyev", "user", passwordEncoder.encode("Ustoz123"), ERole.ROLE_USER);
            User admin = new User("Bakhromjon", "Khasanboyev", "admin", passwordEncoder.encode("Ustoz123"), ERole.ROLE_ADMIN);

            userRepository.saveAll(List.of(user, admin));
        }
    }
}
