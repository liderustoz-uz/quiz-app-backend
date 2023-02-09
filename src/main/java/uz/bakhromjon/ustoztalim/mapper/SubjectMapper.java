package uz.bakhromjon.ustoztalim.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.entity.Subject;
import uz.bakhromjon.ustoztalim.mapper.base.BaseMapper;

import java.util.List;

@Mapper(componentModel = "spring")
@Component(value = "subjectMapperImpl")
public interface SubjectMapper extends
        BaseMapper<Subject, SubjectCreateDTO, SubjectUpdateDTO, SubjectGetDTO> {

    List<SubjectGetDTO> toGetDTO(List<Subject> list);
}
