package uz.bakhromjon.ustoztalim.mappers;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;


public interface BaseMapper<E, CD, UD, GD> {
    E fromCreateDTO(CD createDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateDTO(UD updateDTO, @MappingTarget E entity);

    GD toGetDTO(E entity);
}
