package ru.vsprog.springinaction.chapter5;

/**
 * Created by vsa
 * Date: 10.11.14.
 */
public aspect JudgeAspect {
    public JudgeAspect() {}

    pointcut performance() : execution(* perform(..));

    after() returning() : ru.vsprog.springinaction.chapter5.Audience.performance() {
        System.out.println(criticismEngine.getCriticism());
    }

    // внедряется
    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

}
