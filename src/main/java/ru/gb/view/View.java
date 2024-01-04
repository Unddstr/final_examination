package ru.gb.view;

import ru.gb.services.AnimalCounter;
import ru.gb.services.IAnimalList;

import java.util.Objects;
import java.util.Scanner;

public class View implements IView {

    private final IAnimalList animalList;

    public View(IAnimalList animalList) {
        this.animalList = animalList;
    }

    @Override
    public void run() throws Exception {
        label:
        while (true) {
            String cmd = prompt("""
                    1 - Добавить новое животное
                    2 - Показать список животных
                    3 - Показать список команд животного
                    4 - Добавить новую команду животному
                    5 - Показать общее колличество животных
                    0 - Выход
                    """);
            switch (cmd) {
                case "1":
                    boolean check = true;
                    while (check) {
                        String cmd1 = prompt("""
                                1 - Добавить кота
                                2 - Добавить собаку
                                3 - Добавить хомяка
                                0 - Выход
                                """);

                        switch (cmd1) {
                            case "1", "2", "3" -> addAnimal(cmd1);
                            case "0" -> check = false;
                            default -> System.out.println("\nВведена неправильная цифра!!!\n");
                        }
                    }
                case "2":
                    System.out.println("\n" + animalList.getAnimalList() + "\n");
                    break;
                case "3": {
                    String name = prompt("\nВведите имя:");
                    boolean find = false;
                    for (int i = 0; i < animalList.getAnimalList().size(); i++) {
                        if (Objects.equals(animalList.getAnimalList().get(i).getName(), name)) {
                            find = true;
                            System.out.print("Комманды " + name + ": ");
                            animalList.getAnimalList().get(i).getCommands();
                            System.out.println(" ");
                        }
                    }
                    if (!find) {
                        System.out.println("Животного с таким именем нет в списке!!!");
                    }
                    System.out.println(" ");
                    break;
                }
                case "4": {
                    String name = prompt("\nВведите имя:");
                    String command = prompt("Введите команду:");
                    boolean find = false;
                    for (int i = 0; i < animalList.getAnimalList().size(); i++) {
                        if (Objects.equals(animalList.getAnimalList().get(i).getName(), name)) {
                            find = true;
                            animalList.getAnimalList().get(i).addCommand(command);
                        }
                    }
                    if (!find) {
                        System.out.println("Животного с таким именем нет в списке!!!");
                    }
                    System.out.println(" ");
                    break;
                }
                case "5":
                    try (AnimalCounter counter = new AnimalCounter()) {
                        System.out.println("\n" + counter.getCount() + "\n");
                    }
                    break;
                case "0":
                    break label;
                default:
                    System.out.println("\nВведена неправильная цифра!!!\n");
                    break;
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private void addAnimal(String cmd1) throws Exception {
        try (AnimalCounter counter = new AnimalCounter()) {
            counter.add();
        }

        switch (cmd1) {
            case "1" -> {
                String name = prompt("\nВведите имя:");
                String birthday = prompt("Введите дату рождения:");
                System.out.println(" ");
                animalList.addCat(name, birthday);
            }
            case "2" -> {
                String name = prompt("\nВведите имя:");
                String birthday = prompt("Введите дату рождения:");
                System.out.println(" ");
                animalList.addDog(name, birthday);
            }
            case "3" -> {
                String name = prompt("\nВведите имя:");
                String birthday = prompt("Введите дату рождения:");
                System.out.println(" ");
                animalList.addHamster(name, birthday);
            }
        }
    }

}
