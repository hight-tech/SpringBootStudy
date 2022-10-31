package com.yang;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Author yang
 * @Date 2022/8/4
 */
public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer Task run...");
            }
        };
        timer.schedule(task,0,2000);
    }
}
