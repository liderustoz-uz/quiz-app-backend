package uz.bakhromjon.ustoztalim.controller;

import org.springframework.web.bind.annotation.*;
import uz.bakhromjon.ustoztalim.exception.user.DataNotFoundException;
import uz.bakhromjon.ustoztalim.response.GenericResponse;

public interface BaseCRUDController<GD, CD, UD> {
    @PostMapping()
    GenericResponse<GD> create(@RequestBody CD createDTO) throws DataNotFoundException;

    @PutMapping()
    GenericResponse<GD> update(@RequestBody UD updateDTO) throws DataNotFoundException;

    @GetMapping("/{id}")
    GenericResponse<GD> get(@PathVariable(name = "id") Long id) throws DataNotFoundException;

    @DeleteMapping()
    GenericResponse<Boolean> delete(@RequestParam(name = "id") Long id) throws DataNotFoundException;
}
