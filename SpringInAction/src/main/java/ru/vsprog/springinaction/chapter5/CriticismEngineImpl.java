package ru.vsprog.springinaction.chapter5;

/**
 * Created by vsa
 * Date: 10.11.14.
 */
public class CriticismEngineImpl implements CriticismEngine {
    public CriticismEngineImpl() {
    }

    @Override
    public String getCriticism() {
        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    // внедряется
    private String[] criticismPool;

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}
