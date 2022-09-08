package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-01 18:21
 * @desc:
 */
public class 锁对象 {
    public synchronized void methodA() throws Exception{
        System.out.println("begin methodA threadName="+Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("end");
    }


    public static void main(String[] args) {
        锁对象 obj=new 锁对象();
        ThreadA threadA=new ThreadA(obj);
        threadA.setName("a");
        ThreadA threadB=new ThreadA(obj);
        threadB.setName("b");
        threadA.start();
        threadB.start();

    }

}

class ThreadA extends Thread{
    private 锁对象 obj;
    public ThreadA(锁对象 obj){
        this.obj=obj;
    }

    @Override
    public void run() {
        try {
            obj.methodA();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadB extends Thread{
    private 锁对象 obj;
    public ThreadB(锁对象 obj){
        this.obj=obj;
    }

    @Override
    public void run() {
        try {
            obj.methodA();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}