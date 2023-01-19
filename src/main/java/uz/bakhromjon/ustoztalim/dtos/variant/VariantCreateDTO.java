package uz.bakhromjon.ustoztalim.dtos.variant;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VariantCreateDTO {
    @Schema(example = "Savol", description = "The text of the Variant")
    private String text;

    @Schema(example = "true", description = "The true/false of the Variant")
    private Boolean isTrue;
}
