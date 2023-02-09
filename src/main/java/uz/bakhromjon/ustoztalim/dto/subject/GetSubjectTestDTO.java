package uz.bakhromjon.ustoztalim.dto.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dto.PageRequest;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetSubjectTestDTO {
    private Long subjectId;
    private PageRequest pageRequest = new PageRequest();
}
