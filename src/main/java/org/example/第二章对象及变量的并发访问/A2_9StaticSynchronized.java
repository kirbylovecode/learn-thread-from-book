package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-02 10:31
 * @desc: 锁一个类——synchronized(xxx.class) = synchronized static
 */
public class A2_9StaticSynchronized {

    public synchronized  void printA(){
        System.out.println("name="+Thread.currentThread().getName()+" 进入printA的时间 "+System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("name="+Thread.currentThread().getName()+" 离开printA的时间 "+System.currentTimeMillis());
    }
    public synchronized  void printB(){
        System.out.println("name="+Thread.currentThread().getName()+" 进入printB的时间 "+System.currentTimeMillis());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("name="+Thread.currentThread().getName()+" 离开printB的时间 "+System.currentTimeMillis());
    }

    public static void main(String[] args) {
        A2_9StaticSynchronized obj=new A2_9StaticSynchronized();
        A2_9StaticSynchronized obj2=new A2_9StaticSynchronized();
        ThreadA2_9_01 a=new ThreadA2_9_01(obj);
        a.setName("A");
        a.start();

        ThreadA2_9_02 b=new ThreadA2_9_02(obj2);
        b.setName("B");
        b.start();
    }
}

class ThreadA2_9_01 extends Thread{
    A2_9StaticSynchronized a;
    public ThreadA2_9_01(A2_9StaticSynchronized a){
        this.a=a;
    }

    @Override
    public void run() {
        a.printA();
    }
}
class ThreadA2_9_02 extends Thread{
    A2_9StaticSynchronized a;
    public ThreadA2_9_02(A2_9StaticSynchronized a){
        this.a=a;
    }

    @Override
    public void run() {
        a.printB();
    }
}
