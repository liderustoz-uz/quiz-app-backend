package uz.bakhromjon.ustoztalim.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Variant {

    private String code = RandomStringUtils.randomAlphabetic(20);
    private Boolean isTrue;

    private String text;

}
