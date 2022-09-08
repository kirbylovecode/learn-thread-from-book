package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-01 18:29
 * @desc:
 */
public class 锁对象2 {
    public synchronized void methodA() throws Exception{
        System.out.println("begin methodA threadName="+Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("end endTime="+System.currentTimeMillis());
    }
    public void methodB() throws Exception{
        System.out.println("begin methodB threadName="+Thread.currentThread().getName());
        Thread.sleep(5000);
        System.out.println("end ");
    }

    public static void main(String[] args) {
        锁对象2 obj=new 锁对象2();
        ThreadAA a=new ThreadAA(obj);
        a.setName("a");
        ThreadBB b=new ThreadBB(obj);
        b.setName("b");
        a.start();
        b.start();

    }

}

class ThreadAA extends Thread{
    private 锁对象2 obj;
    public ThreadAA(锁对象2 obj){
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

class ThreadBB extends Thread{
    private 锁对象2 obj;
    public ThreadBB(锁对象2 obj){
        this.obj=obj;
    }

    @Override
    public void run() {
        try {
            obj.methodB();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
