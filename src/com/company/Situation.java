package com.company;

public class Situation
{
    public Actor actor;

    public boolean isgGameComplete = false;

    public String result = "выиграли";

    public Situation(final Actor actor)
    {
        this.actor = actor;
    }

    public void stopGame()
    {
        System.out.println("Игра закончилась.");
        if (actor.universityResult.equals("отчислены"))
        {
            System.out.println(actor.name + " вы были отчисленны из университета и проиграли");
        }
        else
        {
            System.out.println(actor.name + " вы не были отчисленны из университета и выиграли");
        }
    }
}
