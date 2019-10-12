package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static int ARTEM_ID = 1;
    static int MARINA_ID = 2;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Actor selectedActor = selectActor(input);
        System.out.println("Вы выбрали: " + selectedActor.name);

        Situation situation = new Situation(selectedActor);

        //первый шаг
        situation = goToTheUniversity(input, situation);

        situation.stopGame();
    }

    private static Situation goToTheUniversity(Scanner input, Situation situation)
    {
        System.out.println("Пойти в университет? Да - 1, нет - 2");
        int inputValue = input.nextInt();
        if(inputValue == 1)
        {
            System.out.println("Вы пошли в универ");
            situation.result = "выиграли";
            situation.actor.universityResult = "В процессе";
        }
        else if (inputValue == 2)
        {
            System.out.println("Вы не пошли в универ");
            situation.result = "проиграли";
            if (isExpelledFromUniversity(situation.actor))
            {
                situation.actor.universityResult = "отчислены";
            }
            situation.actor.universityResult = "В процессе";
        }
        else
        {
            System.out.println("Вы не можете попасть в 1 или 2");
        }
        return situation;
    }

    private static boolean isExpelledFromUniversity(Actor actor)
    {
        Random r = new Random();
        int randomInt = r.nextInt(200) + 1;
        if (randomInt > (actor.luck + actor.smart))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static Actor selectActor(Scanner input)
    {
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
                System.out.println("Подумайте еще раз, это не совсем верная цифорка (подсказка!!!верная цифра это 2))");
                inputValue = input.nextInt();
            }
        }
        return selectedActor;
    }

    private static Actor AtremActor()
    {
        Actor actor = new Actor();
        actor.id = ARTEM_ID;
        actor.name = "Артем";
        actor.luck = 0;
        actor.smart = 60;
        return actor;
    }

    private static Actor MarinaActor()
    {
        Actor actor = new Actor();
        actor.id = MARINA_ID;
        actor.name = "Марина";
        actor.smart = 10;
        actor.luck = 90;
        return actor;
    }
}
