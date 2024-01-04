package ru.gb.controller;

import ru.gb.services.IAnimalList;
import ru.gb.services.AnimalList;
import ru.gb.view.IView;
import ru.gb.view.View;

public class Controller {
    IAnimalList iAnimalList;
    IView iView;

    public Controller() {
        this.iAnimalList = new AnimalList();
        this.iView = new View(iAnimalList);
    }

    public void run() throws Exception {
        iView.run();
    }
}
