package com.sva.command.undo;

/**
 * @author vsa
 * @created 10.10.16
 */
public interface Command {
    void execute();

    void undo();
}
