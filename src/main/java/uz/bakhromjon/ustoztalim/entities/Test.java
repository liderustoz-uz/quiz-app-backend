package uz.bakhromjon.ustoztalim.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Test extends Auditable {
    private String question;

    @ManyToOne
    private Subject subject;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Variant> variants;
}
