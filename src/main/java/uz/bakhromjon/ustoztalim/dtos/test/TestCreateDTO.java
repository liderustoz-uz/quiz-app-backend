package uz.bakhromjon.ustoztalim.dtos.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dtos.variant.VariantCreateDTO;
import uz.bakhromjon.ustoztalim.entities.Variant;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestCreateDTO {
    private Long subjectId;
    private String question;
    private List<VariantCreateDTO> variants;
}
