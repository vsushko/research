package ru.vsprog.springinaction.chapter16;

import ru.vsprog.springinaction.chapter1.Knight;
import ru.vsprog.springinaction.chapter1.Quest;

import javax.annotation.Resource;

/**
 * Created by vsa
 * Date: 04.12.14.
 */
public class BraveKnight implements Knight {
    // Внедрение сценария подвига
    @Resource(name = "quest")
    private Quest quest;

    String name;

    public BraveKnight(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void embarkOnQuest() {
        quest.embark();
    }
}
