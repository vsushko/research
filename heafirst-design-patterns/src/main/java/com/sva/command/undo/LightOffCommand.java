package com.sva.command.undo;

/**
 * @author vsa
 * @created 10.10.16
 */
public class LightOffCommand implements Command {

    Light light;
    int level;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        level = light.getLevel();
        light.off();
    }

    public void undo() {
        light.dim(level);
    }
}
