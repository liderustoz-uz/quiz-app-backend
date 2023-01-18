package uz.bakhromjon.ustoztalim.services;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractService<R, M> {
    public R repository;
    public M mapper;
}
