package uz.bakhromjon.ustoztalim.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.ustoztalim.dtos.test.TestCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestGetDTO;
import uz.bakhromjon.ustoztalim.dtos.test.TestUpdateDTO;
import uz.bakhromjon.ustoztalim.exceptions.compileTime.DataNotFoundException;
import uz.bakhromjon.ustoztalim.response.GenericResponse;
import uz.bakhromjon.ustoztalim.services.test.TestService;

@RestController
@RequestMapping("/test")
public class TestController extends AbstractController<TestService>
        implements BaseCRUDController<TestGetDTO, TestCreateDTO, TestUpdateDTO> {

    public TestController(TestService service) {
        super(service);
    }

    @Override
    public GenericResponse<TestGetDTO> create(TestCreateDTO createDTO) throws DataNotFoundException {
        TestGetDTO data = service.create(createDTO);
        return GenericResponse.ok(data);
    }

    @Override
    public GenericResponse<TestGetDTO> update(TestUpdateDTO updateDTO) throws DataNotFoundException {
        TestGetDTO data = service.update(updateDTO);
        return GenericResponse.ok(data);
    }

    @Override
    public GenericResponse<TestGetDTO> get(Long id) throws DataNotFoundException {
        TestGetDTO data = service.get(id);
        return GenericResponse.ok(data);
    }

    @Override
    public GenericResponse<Boolean> delete(Long id) {
        Boolean data = service.delete(id);
        return GenericResponse.ok(data);
    }

}
