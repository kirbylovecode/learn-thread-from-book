package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-09-01 9:22
 * @desc:
 */
public class SuspendResume方法独占 {
    public synchronized void printString(){
        System.out.println("begin");
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("a线程永远suspend了");
            Thread.currentThread().suspend();
        }
        System.out.println("end");
    }


    //在锁内被暂停，很容易造成锁住的对象永远不会被释放！
    public static void main(String[] args) throws Exception{
        SuspendResume方法独占 obj=new SuspendResume方法独占();
        Thread thread1=new Thread(){
            @Override
            public void run() {
                obj.printString();
            }
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(1000);

        Thread thread2=new Thread(){
            @Override
            public void run() {
                System.out.println("1111111");
                obj.printString();
            }
        };
        thread2.start();

    }
}
