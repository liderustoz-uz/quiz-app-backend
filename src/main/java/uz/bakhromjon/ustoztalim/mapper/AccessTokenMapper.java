package uz.bakhromjon.ustoztalim.mapper;

import org.mapstruct.Mapper;
import uz.bakhromjon.ustoztalim.dto.token.AccessTokenGetDTO;
import uz.bakhromjon.ustoztalim.entity.AccessToken;

@Mapper(componentModel = "spring")
public interface AccessTokenMapper {
    AccessTokenGetDTO toGetDTO(AccessToken accessToken);
}
