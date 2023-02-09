package uz.bakhromjon.ustoztalim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.ustoztalim.entity.User;

import java.util.Optional;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:43
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
