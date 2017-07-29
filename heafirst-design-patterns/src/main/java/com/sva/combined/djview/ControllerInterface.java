package com.sva.combined.djview;

/**
 * @author: vsa
 * @date: 29.10.16
 */
public interface ControllerInterface {

    void start();

    void stop();

    void increaseBPM();

    void decreaseBPM();

    void setBPM(int bpm);
}
