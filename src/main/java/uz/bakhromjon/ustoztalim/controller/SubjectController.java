package uz.bakhromjon.ustoztalim.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.ustoztalim.controller.base.AbstractController;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dto.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.exception.user.DataNotFoundException;
import uz.bakhromjon.ustoztalim.response.GenericResponse;
import uz.bakhromjon.ustoztalim.service.abstraction.SubjectService;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController extends AbstractController<SubjectService>
        implements BaseCRUDController<SubjectGetDTO, SubjectCreateDTO, SubjectUpdateDTO> {

    public SubjectController(SubjectService service) {
        super(service);
    }

    // TODO: 2/1/2023 api larni secure qilish kerak
    @Operation(summary = "Fan yaratish")
    @Override
    public GenericResponse<SubjectGetDTO> create(SubjectCreateDTO createDTO) throws DataNotFoundException {
        SubjectGetDTO data = service.create(createDTO);
        return GenericResponse.ok(data);
    }


    @Operation(summary = "Fanni tahrirlash")
    @Override
    public GenericResponse<SubjectGetDTO> update(SubjectUpdateDTO updateDTO) throws DataNotFoundException {
        SubjectGetDTO data = service.update(updateDTO);
        return GenericResponse.ok(data);
    }


    @Operation(summary = "Fanni tahrirlash")
    @Override
    public GenericResponse<SubjectGetDTO> get(Long id) throws DataNotFoundException {
        SubjectGetDTO data = service.get(id);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Fanni o'chirish")
    @Override
    public GenericResponse<Boolean> delete(Long id) throws DataNotFoundException {
        Boolean data = service.delete(id);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Fanlarni listini olish")
    @GetMapping("/list")
    public GenericResponse<List<SubjectGetDTO>> list() {
        List<SubjectGetDTO> subjects = service.list();
        return GenericResponse.ok(subjects);
    }


}
