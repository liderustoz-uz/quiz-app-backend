package uz.bakhromjon.ustoztalim.services.subject;

import org.springframework.stereotype.Service;
import uz.bakhromjon.ustoztalim.consts.ErrorDataKeys;
import uz.bakhromjon.ustoztalim.consts.ErrorMessages;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.entities.Subject;
import uz.bakhromjon.ustoztalim.exceptions.compileTime.DataNotFoundException;
import uz.bakhromjon.ustoztalim.mappers.SubjectMapper;
import uz.bakhromjon.ustoztalim.repositories.SubjectRepository;
import uz.bakhromjon.ustoztalim.services.AbstractService;

import java.util.Optional;

@Service
public class SubjectServiceImpl extends AbstractService<SubjectRepository, SubjectMapper> implements SubjectService {
    public SubjectServiceImpl(SubjectRepository repository, SubjectMapper mapper) {
        super(repository, mapper);
    }

    @Override
    public SubjectGetDTO create(SubjectCreateDTO createDTO) {
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
    public Boolean delete(Long id) {
        repository.deleteById(id);
        return true;
    }

    public Subject getPersist(Long id) throws DataNotFoundException {
        Optional<Subject> optional = repository.findById(id);
        if (optional.isEmpty()) {
            DataNotFoundException.throwException(ErrorMessages.SUBJECT_NOT_FOUND, ErrorDataKeys.SUBJECT_ID, id);
        }
        return optional.get();
    }


}
