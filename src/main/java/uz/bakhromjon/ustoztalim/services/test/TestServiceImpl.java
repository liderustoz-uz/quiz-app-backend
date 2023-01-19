package uz.bakhromjon.ustoztalim.services.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.consts.ErrorDataKeys;
import uz.bakhromjon.ustoztalim.consts.ErrorMessages;
import uz.bakhromjon.ustoztalim.dtos.test.TestCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestGetDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestUpdateDTO;
import uz.bakhromjon.ustoztalim.entities.Subject;
import uz.bakhromjon.ustoztalim.entities.Test;
import uz.bakhromjon.ustoztalim.exceptions.compileTime.DataNotFoundException;
import uz.bakhromjon.ustoztalim.mappers.TestMapper;
import uz.bakhromjon.ustoztalim.repositories.TestRepository;
import uz.bakhromjon.ustoztalim.services.AbstractService;
import uz.bakhromjon.ustoztalim.services.subject.SubjectService;

import java.util.Optional;

@Service
public class TestServiceImpl extends AbstractService<TestRepository, TestMapper> implements TestService {
    @Autowired
    private SubjectService subjectService;

    public TestServiceImpl(TestRepository repository, TestMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public TestGetDTO create(TestCreateDTO createDTO) throws DataNotFoundException {
        Test test = mapper.fromCreateDTO(createDTO);
        test.setSubject(subjectService.getPersist(createDTO.getSubjectId()));
        test = repository.save(test);
        return mapper.toGetDTO(test);
    }

    @Override
    public TestGetDTO update(TestUpdateDTO updateDTO) throws DataNotFoundException {
        Test test = getPersist(updateDTO.getId());
        mapper.fromUpdateDTO(updateDTO, test);
        test = repository.save(test);
        return mapper.toGetDTO(test);
    }

    @Override
    public TestGetDTO get(Long id) throws DataNotFoundException {
        Test test = getPersist(id);
        return mapper.toGetDTO(test);
    }

    @Override
    public Boolean delete(Long id) throws DataNotFoundException {
        Test test = getPersist(id);
        repository.delete(test);
        return true;
    }

    public Test getPersist(Long id) throws DataNotFoundException {
        Optional<Test> optional = repository.findById(id);
        if (optional.isEmpty()) {
            DataNotFoundException.throwException(ErrorMessages.TEST_NOT_FOUND, ErrorDataKeys.TEST_ID, id);
        }
        return optional.get();
    }
}
