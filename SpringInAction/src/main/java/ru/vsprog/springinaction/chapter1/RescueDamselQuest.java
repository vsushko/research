package ru.vsprog.springinaction.chapter1;

public class RescueDamselQuest implements Quest {
    public void embark() throws QuestException {
        System.out.println("Rescuing damsel in distress");
    }
}
