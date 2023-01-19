package uz.bakhromjon.ustoztalim.services;

import uz.bakhromjon.ustoztalim.exceptions.compileTime.DataNotFoundException;

public interface BaseCRUDService<GD, CD, UD> {
    GD create(CD createDTO) throws DataNotFoundException;

    GD update(UD updateDTO) throws DataNotFoundException;

    GD get(Long id) throws DataNotFoundException;

    Boolean delete(Long id) throws DataNotFoundException;
}
