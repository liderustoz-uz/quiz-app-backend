package uz.bakhromjon.ustoztalim.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RandomTestRequest {
    private Long subjectId;
    private Integer count;
}
