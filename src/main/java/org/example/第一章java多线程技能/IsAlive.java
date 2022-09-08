package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-08-31 20:21
 * @desc:
 */
public class IsAlive extends Thread {

    @Override
    public void run() {
        System.out.println("run="+this.isAlive());
    }

    public static void main(String[] args) throws Exception {
        IsAlive isAlive=new IsAlive();
        System.out.println("1=" +isAlive.isAlive());

        isAlive.start();
//        Thread.sleep(1000);
        System.out.println("2=" + isAlive.isAlive());

    }
}
