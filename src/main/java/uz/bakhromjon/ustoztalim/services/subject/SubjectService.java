package uz.bakhromjon.ustoztalim.services.subject;

import uz.bakhromjon.ustoztalim.consts.ErrorDataKeys;
import uz.bakhromjon.ustoztalim.consts.ErrorMessages;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.entities.Subject;
import uz.bakhromjon.ustoztalim.exceptions.compileTime.DataNotFoundException;
import uz.bakhromjon.ustoztalim.services.BaseCRUDService;

import java.util.Optional;

public interface SubjectService extends BaseCRUDService<SubjectGetDTO, SubjectCreateDTO, SubjectUpdateDTO> {
    Subject getPersist(Long id) throws DataNotFoundException;
}
