package ru.gb.services;

import ru.gb.model.*;

import java.util.ArrayList;
import java.util.List;

public class AnimalList implements IAnimalList {

    private final List<Animal> animalList = new ArrayList<>();

    @Override
    public void addCat(String name, String birthday) {
        Animal animal = new Cat(name, birthday);
        this.animalList.add(animal);
    }

    @Override
    public void addDog(String name, String birthday) {
        Animal animal = new Dog(name, birthday);
        this.animalList.add(animal);
    }

    @Override
    public void addHamster(String name, String birthday) {
        Animal animal = new Hamster(name, birthday);
        this.animalList.add(animal);
    }

    // void или boolean???
    @Override
    public boolean removeAnimal(Animal animal) {
        return animalList.remove(animal);
    }

    @Override
    public List<Animal> getAnimalList() {
        return animalList;
    }

    @Override
    public List<Cat> getCats() {
        List<Cat> resultList = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal instanceof Cat) {
                resultList.add((Cat) animal);
            }
        }
        return resultList;
    }

    @Override
    public List<Dog> getDogs() {
        List<Dog> resultList = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal instanceof Dog) {
                resultList.add((Dog) animal);
            }
        }
        return resultList;
    }

    @Override
    public List<Hamster> getHamsters() {
        List<Hamster> resultList = new ArrayList<>();
        for (Animal animal : animalList) {
            if (animal instanceof Hamster) {
                resultList.add((Hamster) animal);
            }
        }
        return resultList;
    }
}
