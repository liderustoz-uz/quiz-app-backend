package uz.bakhromjon.ustoztalim.dtos.variant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dtos.AbstractIDDTO;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VariantUpdateDTO extends AbstractIDDTO {
    private String desc;
}
