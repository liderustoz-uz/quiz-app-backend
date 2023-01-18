package uz.bakhromjon.ustoztalim.repositories;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubjectRepository extends org.springframework.data.jpa.repository.JpaRepository<uz.bakhromjon.ustoztalim.entities.Subject, Long> {
}