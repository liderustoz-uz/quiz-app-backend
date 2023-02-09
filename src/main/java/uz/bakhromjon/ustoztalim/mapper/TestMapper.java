package uz.bakhromjon.ustoztalim.mapper;

import org.mapstruct.*;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.dto.test.TestCreateDTO;
import uz.bakhromjon.ustoztalim.dto.test.TestGetDTO;
import uz.bakhromjon.ustoztalim.dto.test.TestUpdateDTO;
import uz.bakhromjon.ustoztalim.entity.Test;
import uz.bakhromjon.ustoztalim.mapper.base.BaseMapper;

import java.util.List;

@Mapper(componentModel = "spring")
@Component(value = "testMapperImpl")
public interface TestMapper extends
        BaseMapper<Test, TestCreateDTO, TestUpdateDTO, TestGetDTO> {

    List<TestGetDTO> toGetDTO(List<Test> tests);
}
