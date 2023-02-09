package uz.bakhromjon.ustoztalim.service.impl;

import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.constant.ErrorDataKeys;
import uz.bakhromjon.ustoztalim.constant.ErrorMessages;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.entity.Subject;
import uz.bakhromjon.ustoztalim.exception.user.DataNotFoundException;
import uz.bakhromjon.ustoztalim.mapper.SubjectMapper;
import uz.bakhromjon.ustoztalim.repository.SubjectRepository;
import uz.bakhromjon.ustoztalim.service.base.AbstractService;
import uz.bakhromjon.ustoztalim.service.abstraction.SubjectService;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl extends AbstractService<SubjectRepository, SubjectMapper> implements SubjectService {
    public SubjectServiceImpl(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public SubjectGetDTO create(SubjectCreateDTO createDTO) {
        // TODO: 2/9/2023 nomi unique bo'lishi kerak
        Subject subject = mapper.fromCreateDTO(createDTO);
        subject = repository.save(subject);
        return mapper.toGetDTO(subject);
    }

    @Override
    public SubjectGetDTO update(SubjectUpdateDTO updateDTO) throws DataNotFoundException {
        Subject subject = getPersist(updateDTO.getId());
        mapper.fromUpdateDTO(updateDTO, subject);
        subject = repository.save(subject);
        return mapper.toGetDTO(subject);
    }

    @Override
    public SubjectGetDTO get(Long id) throws DataNotFoundException {
        Subject subject = getPersist(id);
        return mapper.toGetDTO(subject);
    }

    @Override
    public Boolean delete(Long id) throws DataNotFoundException {
        Subject subject = getPersist(id);
        repository.delete(subject);
        return true;
    }

    public Subject getPersist(Long id) throws DataNotFoundException {
        Optional<Subject> optional = repository.findById(id);
        if (optional.isEmpty()) {
            DataNotFoundException.throwException(ErrorMessages.SUBJECT_NOT_FOUND, ErrorDataKeys.SUBJECT_ID, id);
        }
        return optional.get();
    }

    @Override
    public List<SubjectGetDTO> list() {
        // TODO: 2/9/2023 createdAt bo'yicha sort qilish kerak
        List<Subject> all = repository.findAll();
        return mapper.toGetDTO(all);
    }
}
