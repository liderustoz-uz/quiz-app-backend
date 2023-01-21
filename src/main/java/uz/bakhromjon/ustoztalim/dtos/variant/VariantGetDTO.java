package uz.bakhromjon.ustoztalim.dtos.variant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dtos.AbstractIDDTO;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VariantGetDTO {
    private UUID code;
    private String text;
}



