package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-01 19:25
 * @desc:
 */
public class 锁重入子类 extends 锁重入父类{
    synchronized public void operateSubMethod(){
        try {
            while (i>0) {
                i--;
                System.out.println("sub print i=" + i);
                Thread.sleep(100);
                this.operateMainMethod();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        MyThread a=new MyThread();
        a.start();
    }

}

class MyThread extends Thread{
    @Override
    public void run() {
        锁重入子类 sub=new 锁重入子类();
        sub.operateSubMethod();
    }
}
