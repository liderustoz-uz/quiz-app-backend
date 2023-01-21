package uz.bakhromjon.ustoztalim.dtos.test;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.annotations.CollectionSize;
import uz.bakhromjon.ustoztalim.dtos.AbstractIDDTO;
import uz.bakhromjon.ustoztalim.dtos.variant.VariantCreateDTO;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestUpdateDTO extends AbstractIDDTO {
    @Schema(example = "1", type = "Long", description = "The Id of the subject")
    private Long subjectId;

    @Schema(example = "What does that mean 'question' in uzbek?", type = "String", description = "The question of the Test")
    private String question;

    @Schema(type = "VariantCreateDTO", description = "The variants of the Test")
    @CollectionSize
    private List<VariantCreateDTO> variants;
}


