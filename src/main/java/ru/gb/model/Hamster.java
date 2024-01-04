package ru.gb.model;

public class Hamster extends Animal {

    private static int count;
    private final int hamsterID;

    public Hamster(String name, String birthday) {
        super(name, birthday);
        count++;
        this.hamsterID = count;
    }

    public int getHamsterID() {
        return hamsterID;
    }

    @Override
    public String toString() {
        return "\nhamsterID: " + hamsterID + super.toString();
    }
}
