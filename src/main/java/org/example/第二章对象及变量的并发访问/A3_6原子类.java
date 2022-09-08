package org.example.第二章对象及变量的并发访问;

import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author: joe
 * @date: 2022-09-02 13:47
 * @desc:
 */
public class A3_6原子类 {
//    public static AtomicLong atomicLong=new AtomicLong();
    public static long atomicLong=0;
    public synchronized void addNum(){
//        System.out.println(Thread.currentThread().getName()+" 加了一百之后的值是："+atomicLong.addAndGet(100));
//        atomicLong.addAndGet(1);
        atomicLong=atomicLong+100;
        System.out.println(Thread.currentThread().getName()+" 加了一百之后的值是："+atomicLong);
        atomicLong=atomicLong+1;
    }

    public static void main(String[] args) {
        A3_6原子类 obj=new A3_6原子类();
        ThreadA3_6_1[] array=new ThreadA3_6_1[5];
        for (int i = 0; i < array.length; i++) {
            array[i]=new ThreadA3_6_1(obj);
        }
        for (int i = 0; i < array.length; i++) {
            array[i].start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        System.out.println(obj.atomicLong.get());
        System.out.println(atomicLong);
    }
}

class ThreadA3_6_1 extends Thread{
    private A3_6原子类 obj;
    public ThreadA3_6_1(A3_6原子类 obj){
        this.obj=obj;
    }

    @Override
    public void run() {
        obj.addNum();
    }
}