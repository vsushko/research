package com.sva.combined.djview;

/**
 * @author: vsa
 * @date: 29.10.16
 */
public class DJTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        ControllerInterface controller = new HeartController(heartModel);
    }
}
