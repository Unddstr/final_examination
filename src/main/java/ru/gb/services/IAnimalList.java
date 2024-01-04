package ru.gb.services;

import ru.gb.model.Animal;
import ru.gb.model.Cat;
import ru.gb.model.Dog;
import ru.gb.model.Hamster;

import java.util.List;

public interface IAnimalList {

    void addCat(String name, String birthday);

    void addDog(String name, String birthday);

    void addHamster(String name, String birthday);

    boolean removeAnimal(Animal animal);

    List<Animal> getAnimalList();

    List<Cat> getCats();

    List<Dog> getDogs();

    List<Hamster> getHamsters();

}
