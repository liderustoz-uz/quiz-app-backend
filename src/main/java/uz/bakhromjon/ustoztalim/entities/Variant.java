package uz.bakhromjon.ustoztalim.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SQLDelete(sql = "update variant set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
public class Variant extends Auditable {

    private Boolean isTrue;

    private String text;
}
