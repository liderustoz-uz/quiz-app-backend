package uz.bakhromjon.ustoztalim.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "update test set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
public class Test extends Auditable {
    private String question;

    @ManyToOne
    private Subject subject;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Variant> variants;
}
