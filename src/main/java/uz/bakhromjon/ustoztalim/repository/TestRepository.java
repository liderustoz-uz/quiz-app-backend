package uz.bakhromjon.ustoztalim.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.ustoztalim.entity.Test;

import java.util.List;

@Repository
@Transactional
public interface TestRepository extends JpaRepository<Test, Long> {
    List<Test> findAllBySubjectId(Long subjectId, PageRequest pageRequest);

    List<Test> findAllBySubjectId(Long subjectId);
}

