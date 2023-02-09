package uz.bakhromjon.ustoztalim.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import uz.bakhromjon.ustoztalim.enums.ERole;

/**
 * @author : Bakhromjon Khasanboyev
 * @since : 31/10/22, Mon, 21:41
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
@SQLDelete(sql = "update users set is_deleted = true where id = ?")
@Where(clause = "is_deleted = false")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 120)
    private String password;

    private ERole role;

    private Boolean isDeleted = Boolean.FALSE;

    public User(String firstName, String lastName, String username, String password, ERole role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.role = role;
    }
}