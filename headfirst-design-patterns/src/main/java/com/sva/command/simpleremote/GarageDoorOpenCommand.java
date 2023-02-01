package com.sva.command.simpleremote;

/**
 * @author vsa
 * @created 20.09.16
 */
public class GarageDoorOpenCommand implements Command {

    GarageDoor door;

    public GarageDoorOpenCommand(GarageDoor door) {
        this.door = door;
    }

    @Override
    public void execute() {
        door.up();
    }
}
