package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-08-31 17:57
 * @desc:
 */
public class MyThread01 extends Thread{
    @Override
    public void run() {
        super.run();
        System.out.println("mythread");
    }




    public static void main(String[] args) {
        MyThread01 thread = new MyThread01();
        thread.start();
        System.out.println("end");
        thread.start();

    }
}
