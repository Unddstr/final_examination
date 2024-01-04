package ru.gb.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements IAnimal {
    private String name;
    private final List<String> commands = new ArrayList<>();
    private final String birthday;

    public Animal(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getCommands() {
        for (String command : commands) {
            System.out.print(command + " ");
        }
    }

    @Override
    public void addCommand(String newCommand) {
        commands.add(newCommand);
    }

    @Override
    public String getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return ", Имя: " + name +
                ", Команды: " + commands +
                ", День рождения: " + birthday;
    }

}
