package uz.bakhromjon.ustoztalim.response;

/**
 * @author : Bakhromjon Khasanboyev
 **/

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePage<T> {
    private List<T> content;
    private Long totalElements;
    private Integer totalPages;

    private Integer number;
    private Integer numberOfElements;


    public static <T> ResponsePage<T> build(Page<T> page) {
        return new ResponsePage<>(page.getContent(), page.getTotalElements(),
                page.getTotalPages(), page.getNumber(), page.getNumberOfElements());
    }


    public static <E, GD> ResponsePage<GD> build(Page<E> page, List<GD> content) {
        return new ResponsePage<>(content, page.getTotalElements(),
                page.getTotalPages(), page.getNumber(), page.getNumberOfElements());
    }
}
