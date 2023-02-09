package uz.bakhromjon.ustoztalim.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.ustoztalim.controller.base.AbstractController;
import uz.bakhromjon.ustoztalim.dto.subject.GetSubjectTestDTO;
import uz.bakhromjon.ustoztalim.dto.test.*;
import uz.bakhromjon.ustoztalim.exception.user.DataNotFoundException;
import uz.bakhromjon.ustoztalim.request.RandomTestRequest;
import uz.bakhromjon.ustoztalim.response.GenericResponse;
import uz.bakhromjon.ustoztalim.service.abstraction.TestService;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController extends AbstractController<TestService>
        implements BaseCRUDController<TestGetDTO, TestCreateDTO, TestUpdateDTO> {

    public TestController(TestService service) {
        super(service);
    }


    @Operation(summary = "Test yaratish")
    @Override
    public GenericResponse<TestGetDTO> create(TestCreateDTO createDTO) throws DataNotFoundException {
        TestGetDTO data = service.create(createDTO);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Testni tahrirlash")
    @Override
    public GenericResponse<TestGetDTO> update(TestUpdateDTO updateDTO) throws DataNotFoundException {
        TestGetDTO data = service.update(updateDTO);
        return GenericResponse.ok(data);
    }


    @Operation(summary = "Testni olish")
    @Override
    public GenericResponse<TestGetDTO> get(Long id) throws DataNotFoundException {
        TestGetDTO data = service.get(id);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Testni o'chirish")
    @Override
    public GenericResponse<Boolean> delete(Long id) throws DataNotFoundException {
        Boolean data = service.delete(id);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Fan bo'yicha random testlarni olish")
    @PostMapping("/random-tests")
    public GenericResponse<List<TestGetDTO>> getRandomTests(@RequestBody RandomTestRequest randomTestRequest) {
        List<TestGetDTO> tests = service.getRandomTests(randomTestRequest);
        return GenericResponse.ok(tests);
    }


    @Operation(summary = "Fan bo'yicha testlarni olish")
    @PostMapping("/subject")
    public GenericResponse<List<TestGetDTO>> getList(@RequestBody GetSubjectTestDTO testDTO) {
        List<TestGetDTO> tests = service.getList(testDTO);
        return GenericResponse.ok(tests);
    }


}
