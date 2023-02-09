package uz.bakhromjon.ustoztalim.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bakhromjon.ustoztalim.entity.Test;

import java.util.List;

@Repository
@Transactional
public interface TestRepository extends JpaRepository<Test, Long> {

    @Query(nativeQuery = true, value = "select * from test where subject_id = :subjectId order by random() limit :count")
    List<Test> findAllBySubjectId(Long subjectId, Integer count);

    Page<Test> findAllBySubjectId(Long subjectId, PageRequest pageRequest);
}

