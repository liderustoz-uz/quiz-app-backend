package uz.bakhromjon.ustoztalim.service.base;

import uz.bakhromjon.ustoztalim.exception.user.DataNotFoundException;

public interface BaseCRUDService<GD, CD, UD> {
    GD create(CD createDTO) throws DataNotFoundException;

    GD update(UD updateDTO) throws DataNotFoundException;

    GD get(Long id) throws DataNotFoundException;

    Boolean delete(Long id) throws DataNotFoundException;
}
