package uz.bakhromjon.ustoztalim.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    //    @OneToMany(
//            mappedBy = "test",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
    @Type(JsonType.class)
    @Column(columnDefinition = "jsonb")
    private List<Variant> variants = new ArrayList<>();

    private LocalDateTime createdAt = LocalDateTime.now();
}
