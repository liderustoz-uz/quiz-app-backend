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
public class QuizResultDTO {
    private Integer totalCount;
    private Integer correctCount;

    private List<TestGetDTO> tests;
}
