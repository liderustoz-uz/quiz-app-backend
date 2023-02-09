package uz.bakhromjon.ustoztalim.service.abstraction;

import uz.bakhromjon.ustoztalim.dto.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.entity.Subject;
import uz.bakhromjon.ustoztalim.exception.user.DataNotFoundException;
import uz.bakhromjon.ustoztalim.service.base.BaseCRUDService;

import java.util.List;

public interface SubjectService extends BaseCRUDService<SubjectGetDTO, SubjectCreateDTO, SubjectUpdateDTO> {
    Subject getPersist(Long id) throws DataNotFoundException;

    List<SubjectGetDTO> list();
}
