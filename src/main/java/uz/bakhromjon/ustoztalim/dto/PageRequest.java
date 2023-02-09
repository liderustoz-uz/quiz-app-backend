package uz.bakhromjon.ustoztalim.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PageRequest {
    private Integer page = 0;
    private Integer perPage = 20;
}
