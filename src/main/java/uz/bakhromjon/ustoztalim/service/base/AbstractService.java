package uz.bakhromjon.ustoztalim.service.base;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractService<R, M> {
    public R repository;
    public M mapper;
}
