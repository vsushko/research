package ru.vsprog.springinaction.chapter1;

public class DamselRescuingKnight implements Knight {
    private RescueDamselQuest quest;

    public DamselRescuingKnight() {
        quest = new RescueDamselQuest();
    }

    public void embarkOnQuest() throws QuestException {
        quest.embark();
    }
}
