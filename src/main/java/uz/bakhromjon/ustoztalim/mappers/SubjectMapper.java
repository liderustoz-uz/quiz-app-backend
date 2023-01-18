package uz.bakhromjon.ustoztalim.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.entities.Subject;

@Mapper(componentModel = "spring")
@Component(value = "subjectMapperImpl")
public interface SubjectMapper extends
        BaseMapper<Subject, SubjectCreateDTO, SubjectUpdateDTO, SubjectGetDTO> {
}
