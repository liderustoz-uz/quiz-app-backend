package uz.bakhromjon.ustoztalim.controller.base;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractController<S> {
    public S service;
}
