package ru.netology.service;


import ru.netology.exception.NotFoundException;

public class Service {
    public void throwChecked() throws NotFoundException {
        throw new NotFoundException();
    }

    public void throwUnchecked() {
        throw new RuntimeException();
    }
}
