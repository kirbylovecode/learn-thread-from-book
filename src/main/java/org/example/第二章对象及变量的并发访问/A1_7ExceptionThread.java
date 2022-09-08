package org.example.第二章对象及变量的并发访问;

import org.example.第一章java多线程技能.Interrupt;

import java.util.TreeMap;

/**
 * @author: joe
 * @date: 2022-09-01 21:06
 * @desc: 出现异常，锁自动释放
 *
 */
public class A1_7ExceptionThread {

    public synchronized void testMethod(){
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("threadname="+Thread.currentThread().getName()+" run begintime="+System.currentTimeMillis());
            int i=1;
            while (i==1){
                if((""+Math.random()).substring(0,8).equals("0.123456")){
                    System.out.println("threadname="+Thread.currentThread().getName()+" run exceptiontime="+System.currentTimeMillis());
                    //注释掉 下面一行 分别执行，便于理解
                    Integer.parseInt("a");
                }
            }
        }else{
            System.out.println("thread b run time="+System.currentTimeMillis());
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            A1_7ExceptionThread thread=new A1_7ExceptionThread();
            Thread1 a=new Thread1(thread);
            a.setName("a");
            a.start();
            Thread.sleep(500);
            Thread2 b=new Thread2(thread);
            b.setName("b");
            b.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

class Thread1 extends Thread{
    private A1_7ExceptionThread exceptionThread;

    public Thread1(A1_7ExceptionThread thread){
        this.exceptionThread=thread;
    }

    @Override
    public void run() {
        exceptionThread.testMethod();
    }
}

class Thread2 extends Thread{
    private A1_7ExceptionThread exceptionThread;

    public Thread2(A1_7ExceptionThread thread){
        this.exceptionThread=thread;
    }

    @Override
    public void run() {
        exceptionThread.testMethod();
    }
}