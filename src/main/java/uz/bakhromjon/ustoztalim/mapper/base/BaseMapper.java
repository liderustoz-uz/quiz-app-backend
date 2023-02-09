package uz.bakhromjon.ustoztalim.mapper.base;

import org.mapstruct.*;


public interface BaseMapper<E, CD, UD, GD> {
    E fromCreateDTO(CD createDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateDTO(UD updateDTO, @MappingTarget E entity);

    GD toGetDTO(E entity);
}
