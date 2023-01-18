package uz.bakhromjon.ustoztalim.controllers;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class AbstractController<S> {
    public S service;
}
