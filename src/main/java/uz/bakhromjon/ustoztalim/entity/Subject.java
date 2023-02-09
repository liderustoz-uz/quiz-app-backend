package uz.bakhromjon.ustoztalim.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "update subject set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
public class Subject extends Auditable {
    private String name;

    @OneToMany(mappedBy = "subject")
    private Set<Test> tests;

}
