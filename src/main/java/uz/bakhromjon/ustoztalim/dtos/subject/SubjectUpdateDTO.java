package uz.bakhromjon.ustoztalim.dtos.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dtos.AbstractIDDTO;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectUpdateDTO extends AbstractIDDTO {
    private String name;
}
