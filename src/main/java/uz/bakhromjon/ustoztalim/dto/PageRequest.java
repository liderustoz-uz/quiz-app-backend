package uz.bakhromjon.ustoztalim.dto;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.constant.ValidationMessages;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    @Min(value = 0, message = ValidationMessages.PAGE_MIN_VALUE)
    private Integer page = 0;

    @Min(value = 1, message = ValidationMessages.PER_PAGE_MIN_VALUE)
    private Integer perPage = 20;
}
