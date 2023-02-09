package uz.bakhromjon.ustoztalim.dto.test;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dto.AbstractIDDTO;
import uz.bakhromjon.ustoztalim.dto.variant.VariantGetDTO;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestGetDTO extends AbstractIDDTO {
    private String question;

    private List<VariantGetDTO> variants;
}
