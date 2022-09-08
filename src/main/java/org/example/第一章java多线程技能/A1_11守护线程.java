package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-09-01 11:06
 * @desc:
 */
public class A1_11守护线程 extends Thread{
    private int i=0;
    @Override
    public void run() {
        try {
            while (true){
                i++;
                System.out.println("i="+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("yichang");
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws Exception{
        A1_11守护线程 thread2 = new A1_11守护线程();
        thread2.start();
        A1_11守护线程 thread = new A1_11守护线程();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(1000);
        System.out.println("....");

    }
}
