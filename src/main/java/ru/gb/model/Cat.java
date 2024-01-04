package ru.gb.model;

public class Cat extends Animal {

    private static int count;
    private final int catID;

    public Cat(String name, String birthday) {
        super(name, birthday);
        count++;
        this.catID = count;
    }

    public int getCatID() {
        return catID;
    }

    @Override
    public String toString() {
        return "\ncatID: " + catID + super.toString();
    }
}
