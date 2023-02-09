package uz.bakhromjon.ustoztalim.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.ustoztalim.entity.AccessToken;

import java.util.Optional;

@Repository
@Transactional
public interface AccessTokenRepository extends JpaRepository<AccessToken, Long> {

    Optional<AccessToken> findByToken(String accessToken);
}
