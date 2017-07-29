package com.sva.command.party;

/**
 * @author vsa
 * @created 10.10.16
 */
public interface Command {
    public void execute();

    public void undo();
}
