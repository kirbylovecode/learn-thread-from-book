package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-08-31 18:02
 * @desc:
 */
public class MyThread02 extends Thread {

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                int time = (int) (Math.random() * 1000);
                Thread.sleep(time);
                System.out.println("run="+Thread.currentThread().getName());


            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) throws Exception {
        MyThread02 thread02=new MyThread02();
        thread02.setName("myThread02");
        thread02.start();
        for (int i = 0; i <10 ; i++) {
            int time = (int) (Math.random() * 1000);
            Thread.sleep(time);
            System.out.println("run="+Thread.currentThread().getName());
        }

    }
}
