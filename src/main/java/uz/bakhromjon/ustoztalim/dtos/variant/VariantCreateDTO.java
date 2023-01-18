package uz.bakhromjon.ustoztalim.dtos.variant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VariantCreateDTO {
    private String text;
    private Boolean isTrue;
}
