package uz.bakhromjon.ustoztalim.dtos.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.consts.ValidationMessages;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectCreateDTO {
    @Schema(example = "Math", type = "String", description = "The name of the subject")
    @NotNull(message = ValidationMessages.SUBJECT_NAME_NOT_NULL)
    @NotBlank(message = ValidationMessages.SUBJECT_NAME_NOT_BLANK)
    private String name;
}









