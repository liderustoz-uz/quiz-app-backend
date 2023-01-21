package uz.bakhromjon.ustoztalim.dtos.test;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.bakhromjon.ustoztalim.dtos.AbstractIDDTO;
import uz.bakhromjon.ustoztalim.dtos.subject.SubjectGetDTO;
import uz.bakhromjon.ustoztalim.dtos.variant.VariantGetDTO;
import uz.bakhromjon.ustoztalim.entities.Subject;
import uz.bakhromjon.ustoztalim.entities.Variant;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestGetDTO extends AbstractIDDTO {
    private String question;

    private List<VariantGetDTO> variants;
}
