package uz.bakhromjon.ustoztalim.mappers;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bakhromjon.ustoztalim.dtos.variant.VariantCreateDTO;
import uz.bakhromjon.ustoztalim.entities.Variant;

import java.util.List;

@Mapper(componentModel = "spring")
@Component(value = "variantMapperImpl")
public interface VariantMapper {
    List<Variant> fromCreateDTO(List<VariantCreateDTO> createDTOs);
}
