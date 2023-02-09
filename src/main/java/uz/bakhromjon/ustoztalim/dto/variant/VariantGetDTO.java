package uz.bakhromjon.ustoztalim.dto.variant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VariantGetDTO {
    private String code;
    private String text;
    private Boolean isTrue;
}



