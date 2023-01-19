package uz.bakhromjon.ustoztalim.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.ustoztalim.consts.Descriptions;
import uz.bakhromjon.ustoztalim.consts.StatusCodes;
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

    @Operation(summary = "Create Subject")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = StatusCodes.S200,
                    description = Descriptions.SUBJECT_CREATING_OK,
                    content = @Content(mediaType = "application/json"))})
    @Override
    public GenericResponse<SubjectGetDTO> create(SubjectCreateDTO createDTO) throws DataNotFoundException {
        SubjectGetDTO data = service.create(createDTO);
        return GenericResponse.ok(data);
    }


    @Operation(summary = "Update Subject")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = StatusCodes.S200,
                    description = Descriptions.SUBJECT_UPDATING_OK,
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(
                    responseCode = StatusCodes.S400,
                    description = Descriptions.SUBJECT_NOT_FOUND,
                    content = @Content(mediaType = "application/json")),
    })
    @Override
    public GenericResponse<SubjectGetDTO> update(SubjectUpdateDTO updateDTO) throws DataNotFoundException {
        SubjectGetDTO data = service.update(updateDTO);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Get Subject by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = StatusCodes.S200,
                    description = Descriptions.SUBJECT_FINDING_OK,
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(
                    responseCode = StatusCodes.S400,
                    description = Descriptions.SUBJECT_NOT_FOUND,
                    content = @Content(mediaType = "application/json"))})
    @Override
    public GenericResponse<SubjectGetDTO> get(Long id) throws DataNotFoundException {
        SubjectGetDTO data = service.get(id);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Delete Subject by id")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = StatusCodes.S200,
                    description = Descriptions.SUBJECT_DELETING_OK,
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(
                    responseCode = StatusCodes.S400,
                    description = Descriptions.SUBJECT_NOT_FOUND,
                    content = @Content(mediaType = "application/json"))})
    @Override
    public GenericResponse<Boolean> delete(Long id) throws DataNotFoundException {
        Boolean data = service.delete(id);
        return GenericResponse.ok(data);
    }
}
