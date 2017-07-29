package com.sva.combined.djview;

/**
 * @author: vsa
 * @date: 29.10.16
 */
public interface HeartModelInterface {
    int getHeartRate();

    void registerObserver(BeatObserver o);

    void removeObserver(BeatObserver o);

    void registerObserver(BPMObserver o);

    void removeObserver(BPMObserver o);
}
