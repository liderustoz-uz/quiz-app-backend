package uz.bakhromjon.ustoztalim.dto.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dto.AbstractIDDTO;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SubjectGetDTO extends AbstractIDDTO {
    private String name;
}
