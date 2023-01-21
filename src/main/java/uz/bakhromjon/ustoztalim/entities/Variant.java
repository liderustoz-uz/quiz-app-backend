package uz.bakhromjon.ustoztalim.entities;

import jakarta.persistence.Entity;

import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.UUID;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@SQLDelete(sql = "update variant set is_deleted = true where id = ?")
//@Where(clause = "is_deleted = false")
public class Variant {

    private UUID code = UUID.randomUUID();
    private Boolean isTrue;

    private String text;

//    @ManyToOne(fetch = FetchType.LAZY)
//    private Test test;
}
