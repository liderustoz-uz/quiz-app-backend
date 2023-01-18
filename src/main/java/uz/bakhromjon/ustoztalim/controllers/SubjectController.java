package uz.bakhromjon.ustoztalim.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectCreateDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectUpdateDTO;
import uz.bakhromjon.ustoztalim.exceptions.compileTime.DataNotFoundException;
import uz.bakhromjon.ustoztalim.response.GenericResponse;
import uz.bakhromjon.ustoztalim.services.subject.SubjectService;

@RestController
@RequestMapping("/subject")
public class SubjectController extends AbstractController<SubjectService>
        implements BaseCRUDController<SubjectGetDTO, SubjectCreateDTO, SubjectUpdateDTO> {

    public SubjectController(SubjectService service) {
        super(service);
    }

    @Override
    public GenericResponse<SubjectGetDTO> create(SubjectCreateDTO createDTO) throws DataNotFoundException {
        SubjectGetDTO data = service.create(createDTO);
        return GenericResponse.ok(data);
    }

    @Override
    public GenericResponse<SubjectGetDTO> update(SubjectUpdateDTO updateDTO) throws DataNotFoundException {
        SubjectGetDTO data = service.update(updateDTO);
        return GenericResponse.ok(data);
    }

    @Override
    public GenericResponse<SubjectGetDTO> get(Long id) throws DataNotFoundException {
        SubjectGetDTO data = service.get(id);
        return GenericResponse.ok(data);
    }

    @Override
    public GenericResponse<Boolean> delete(Long id) {
        Boolean data = service.delete(id);
        return GenericResponse.ok(data);
    }
}
