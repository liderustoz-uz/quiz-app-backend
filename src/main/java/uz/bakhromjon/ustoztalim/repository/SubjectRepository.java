package uz.bakhromjon.ustoztalim.repository;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface SubjectRepository extends org.springframework.data.jpa.repository.JpaRepository<uz.bakhromjon.ustoztalim.entity.Subject, Long> {
}