package ru.gb.model;

public class Dog extends Animal {

    private static int count;
    private final int dogID;

    public Dog(String name, String birthday) {
        super(name, birthday);
        count++;
        this.dogID = count;
    }

    public int getDogID() {
        return dogID;
    }

    @Override
    public String toString() {
        return "\ndogID: " + dogID + super.toString();
    }
}
