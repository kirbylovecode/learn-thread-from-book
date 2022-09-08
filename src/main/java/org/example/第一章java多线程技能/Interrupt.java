package org.example.第一章java多线程技能;

import java.util.prefs.BackingStoreException;

/**
 * @author: joe
 * @date: 2022-08-31 20:56
 * @desc:中断线程
 */
public class Interrupt extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                System.out.println("i="+(i+1));
                //如果线程被中断 则break
                if (this.isInterrupted()) {
                    throw new Exception();
                }
            }
            System.out.println("hhhhhh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Interrupt interrupt = new Interrupt();
        interrupt.start();
        Thread.sleep(1);
        interrupt.interrupt();
    }
}
