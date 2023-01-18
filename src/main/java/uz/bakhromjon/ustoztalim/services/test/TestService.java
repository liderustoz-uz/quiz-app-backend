package uz.bakhromjon.ustoztalim.services.test;

import uz.bakhromjon.ustoztalim.dtos.test.TestCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestGetDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestUpdateDTO;
import uz.bakhromjon.ustoztalim.services.BaseCRUDService;

public interface TestService extends BaseCRUDService<TestGetDTO, TestCreateDTO, TestUpdateDTO> {
}
