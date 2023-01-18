package uz.bakhromjon.ustoztalim.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.dtos.test.TestCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestGetDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestUpdateDTO;
import uz.bakhromjon.ustoztalim.entities.Test;

@Mapper(componentModel = "spring")
@Component(value = "testMapperImpl")
public interface TestMapper extends
        BaseMapper<Test, TestCreateDTO, TestUpdateDTO, TestGetDTO> {
}
