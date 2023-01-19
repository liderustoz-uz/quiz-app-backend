package uz.bakhromjon.ustoztalim.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AbstractIDDTO {
    @Schema(example = "1", type = "Long", description = "Id")
    private Long id;
}
