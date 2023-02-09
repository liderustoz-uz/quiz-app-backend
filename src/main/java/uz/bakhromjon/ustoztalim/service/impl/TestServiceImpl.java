package uz.bakhromjon.ustoztalim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.constant.ErrorDataKeys;
import uz.bakhromjon.ustoztalim.constant.ErrorMessages;
import uz.bakhromjon.ustoztalim.dto.subject.GetSubjectTestDTO;
import uz.bakhromjon.ustoztalim.dto.test.*;
import uz.bakhromjon.ustoztalim.entity.Test;
import uz.bakhromjon.ustoztalim.exception.user.DataNotFoundException;
import uz.bakhromjon.ustoztalim.mapper.TestMapper;
import uz.bakhromjon.ustoztalim.mapper.VariantMapper;
import uz.bakhromjon.ustoztalim.repository.TestRepository;
import uz.bakhromjon.ustoztalim.request.RandomTestRequest;
import uz.bakhromjon.ustoztalim.response.ResponsePage;
import uz.bakhromjon.ustoztalim.service.base.AbstractService;
import uz.bakhromjon.ustoztalim.service.abstraction.SubjectService;
import uz.bakhromjon.ustoztalim.service.abstraction.TestService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TestServiceImpl extends AbstractService<TestRepository, TestMapper> implements TestService {
    @Autowired
    private SubjectService subjectService;

    @Autowired
    private VariantMapper variantMapper;

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

    @Override
    public List<TestGetDTO> getRandomTests(RandomTestRequest randomTestRequest) {
        List<Test> all = repository.findAllBySubjectId(randomTestRequest.getSubjectId(), 20);
        randomizeVariantsOfTests(all);
        return mapper.toGetDTO(all);
    }

    private void randomizeVariantsOfTests(List<Test> tests) {
        for (Test test : tests) {
            Collections.shuffle(test.getVariants());
        }
    }

    @Override
    public ResponsePage<TestGetDTO> getList(GetSubjectTestDTO testDTO) {
        Page<Test> page = repository.findAllBySubjectId(testDTO.getSubjectId(),
                PageRequest.of(testDTO.getPageRequest().getPage(), testDTO.getPageRequest().getPerPage(),
                        Sort.by(Sort.Order.by("createdAt"))));
        List<TestGetDTO> content = mapper.toGetDTO(page.getContent());
        return ResponsePage.build(page, content);
    }

}
