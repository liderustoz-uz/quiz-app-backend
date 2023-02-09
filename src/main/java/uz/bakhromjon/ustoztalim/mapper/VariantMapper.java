package uz.bakhromjon.ustoztalim.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.dto.variant.VariantCreateDTO;
import uz.bakhromjon.ustoztalim.entity.Variant;

import java.util.List;

@Mapper(componentModel = "spring")
@Component(value = "variantMapperImpl")
public interface VariantMapper {
    List<Variant> fromCreateDTO(List<VariantCreateDTO> createDTOs);
}
