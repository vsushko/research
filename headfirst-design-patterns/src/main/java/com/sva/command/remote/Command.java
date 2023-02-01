package com.sva.command.remote;

/**
 * @author vsa
 * @created 20.09.16
 */
public interface Command {

    void execute();

    void undo();
}
