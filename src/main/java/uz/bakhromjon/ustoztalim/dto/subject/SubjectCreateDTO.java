package uz.bakhromjon.ustoztalim.dto.subject;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.common.SelfValidating;
import uz.bakhromjon.ustoztalim.constant.ValidationMessages;


@Setter
@Getter
@NoArgsConstructor
public class SubjectCreateDTO extends SelfValidating<SubjectCreateDTO> {
    @Schema(example = "Math", type = "String", description = "The name of the subject")
    @NotNull(message = ValidationMessages.SUBJECT_NAME_NOT_NULL)
    @NotBlank(message = ValidationMessages.SUBJECT_NAME_NOT_BLANK)
    private String name;

    public SubjectCreateDTO(String name) {
        this.name = name;
        validateSelf();
    }
}









