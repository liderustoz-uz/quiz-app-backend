package uz.bakhromjon.ustoztalim.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.bakhromjon.ustoztalim.consts.Descriptions;
import uz.bakhromjon.ustoztalim.consts.StatusCodes;
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


    @Operation(summary = "Create Subject")
    @ApiResponses(value = {@ApiResponse(
            responseCode = StatusCodes.S200,
            description = Descriptions.TEST_CREATING_OK,
            content = @Content(mediaType = "application/json")),
            @ApiResponse(
                    responseCode = StatusCodes.S400,
                    description = Descriptions.TEST_NOT_FOUND,
                    content = @Content(mediaType = "application/json")),
    })
    @Override
    public GenericResponse<TestGetDTO> create(TestCreateDTO createDTO) throws DataNotFoundException {
        TestGetDTO data = service.create(createDTO);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Update Subject")
    @ApiResponses(value = {@ApiResponse(
            responseCode = StatusCodes.S200,
            description = Descriptions.TEST_UPDATING_OK,
            content = @Content(mediaType = "application/json")),
            @ApiResponse(
                    responseCode = StatusCodes.S400,
                    description = Descriptions.TEST_NOT_FOUND,
                    content = @Content(mediaType = "application/json")),
    })
    @Override
    public GenericResponse<TestGetDTO> update(TestUpdateDTO updateDTO) throws DataNotFoundException {
        TestGetDTO data = service.update(updateDTO);
        return GenericResponse.ok(data);
    }


    @Operation(summary = "Get Subject by id")
    @ApiResponses(value = {@ApiResponse(
            responseCode = StatusCodes.S200,
            description = Descriptions.TEST_FINDING_OK,
            content = @Content(mediaType = "application/json")),
            @ApiResponse(
                    responseCode = StatusCodes.S400,
                    description = Descriptions.TEST_NOT_FOUND,
                    content = @Content(mediaType = "application/json"))})
    @Override
    public GenericResponse<TestGetDTO> get(Long id) throws DataNotFoundException {
        TestGetDTO data = service.get(id);
        return GenericResponse.ok(data);
    }

    @Operation(summary = "Delete Subject by id")
    @ApiResponses(value = {@ApiResponse(
            responseCode = StatusCodes.S200,
            description = Descriptions.TEST_DELETING_OK,
            content = @Content(mediaType = "application/json")),
            @ApiResponse(
                    responseCode = StatusCodes.S400,
                    description = Descriptions.TEST_NOT_FOUND,
                    content = @Content(mediaType = "application/json"))})
    @Override
    public GenericResponse<Boolean> delete(Long id) throws DataNotFoundException {
        Boolean data = service.delete(id);
        return GenericResponse.ok(data);
    }

}
