package uz.bakhromjon.ustoztalim.dto.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizCheckRequestDTO {
    private List<TestCheckDTO> tests;
}




