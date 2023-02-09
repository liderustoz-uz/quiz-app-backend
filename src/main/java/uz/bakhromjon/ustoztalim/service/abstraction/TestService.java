package uz.bakhromjon.ustoztalim.service.abstraction;

import uz.bakhromjon.ustoztalim.dto.subject.GetSubjectTestDTO;
import uz.bakhromjon.ustoztalim.dto.test.*;
import uz.bakhromjon.ustoztalim.request.RandomTestRequest;
import uz.bakhromjon.ustoztalim.response.ResponsePage;
import uz.bakhromjon.ustoztalim.service.base.BaseCRUDService;

import java.util.List;

public interface TestService extends BaseCRUDService<TestGetDTO, TestCreateDTO, TestUpdateDTO> {
    List<TestGetDTO> getRandomTests(RandomTestRequest randomTestRequest);

    ResponsePage<TestGetDTO> getList(GetSubjectTestDTO testDTO);
}
