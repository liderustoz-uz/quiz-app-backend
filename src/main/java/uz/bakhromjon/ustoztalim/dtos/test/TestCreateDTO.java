package uz.bakhromjon.ustoztalim.dtos.test;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.annotations.CollectionSize;
import uz.bakhromjon.ustoztalim.consts.ErrorMessages;
import uz.bakhromjon.ustoztalim.consts.ValidationMessages;
import uz.bakhromjon.ustoztalim.dtos.variant.VariantCreateDTO;
import uz.bakhromjon.ustoztalim.entities.Variant;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestCreateDTO {
    @Schema(example = "1", type = "Long", description = "The Id of the subject")
    @NotNull(message = ValidationMessages.SUBJECT_ID_NOT_NULL)
    private Long subjectId;

    @Schema(example = "What does that mean 'question' in uzbek?", type = "String", description = "The question of the Test")
    @NotNull(message = ValidationMessages.QUESTION_NOT_NULL)
    @NotBlank(message = ValidationMessages.QUESTION_NOT_BLANK)
    private String question;

    @Schema(type = "VariantCreateDTO", description = "The variants of the Test")
    @CollectionSize
    private List<VariantCreateDTO> variants;
}
