package uz.bakhromjon.ustoztalim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.entity.User;
import uz.bakhromjon.ustoztalim.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    public Boolean existsByUsername(String username) {
        return repository.existsByUsername(username);
    }

    public User save(User user) {
        return repository.save(user);
    }
}
