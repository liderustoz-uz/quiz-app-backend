package uz.bakhromjon.ustoztalim.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.ustoztalim.entities.Variant;

@Repository
@Transactional
public interface VariantRepository extends JpaRepository<Variant, Long> {
}