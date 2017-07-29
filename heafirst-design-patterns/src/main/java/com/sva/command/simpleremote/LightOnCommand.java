package com.sva.command.simpleremote;

/**
 * @author vsa
 * @created 20.09.16
 */
public class LightOnCommand implements Command {

    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
