package uz.bakhromjon.ustoztalim.dtos.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateDTO {
    @Schema(example = "Math", type = "String", description = "The name of the subject")
    private String name;
}









