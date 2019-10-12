package com.company;

import java.util.Scanner;

public class Main {

    static int ARTEM_ID = 1;
    static int MARINA_ID = 2;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Привет, для входа в квест нажмите цифру, чтобы выбрать персонажа 1-Артём, 2-Марина");
        int inputValue = input.nextInt();


        Actor selectedActor = null;
        boolean needSelected = true;
        while (needSelected)
        {
            if(inputValue == ARTEM_ID)
            {
                selectedActor = AtremActor();
                needSelected = false;
            }
            else if(inputValue == MARINA_ID)
            {
                selectedActor = MarinaActor();
                needSelected = false;
            }
            else {
                System.out.println("Подумайте еще раз, это не совсем верная циферка (подсказка!!!верная цифра это 2))");
                inputValue = input.nextInt();
            }
        }
        System.out.println("Поздравляю!Вы выбрали: " + selectedActor.name);
    }

    private static Actor AtremActor()
    {
        Actor actor = new Actor();
        actor.id = 1;
        actor.name = "Марина";
        return actor;
    }

    private static Actor MarinaActor()
    {
        Actor actor = new Actor();
        actor.id = 1;
        actor.name = "Артем";
        return actor;
    }
}
