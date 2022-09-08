package org.example.第二章对象及变量的并发访问;

import org.example.util.MyCommonUtils;

/**
 * @author: joe
 * @date: 2022-09-01 21:40
 * @desc:
 */
public class A2_1同步语句块 {
    private String getData1;
    private String getData2;


    //优化前
//    public synchronized void doLongTimeTask()  {
//        try {
//            System.out.println("begin task");
//            Thread.sleep(3000);
//            getData1="值1 threadname="+ Thread.currentThread().getName();
//            getData2="值2 threadname="+ Thread.currentThread().getName();
//            System.out.println(getData1);
//            System.out.println(getData2);
//            System.out.println("end task");
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }


        //优化后
        public void doLongTimeTask()  {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String a="值1 threadname="+ Thread.currentThread().getName();
            String b="值2 threadname="+ Thread.currentThread().getName();
            synchronized (this){
                getData1=a;
                getData2=b;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws Exception{
        A2_1同步语句块 task=new A2_1同步语句块();
        MyThread1 a=new MyThread1(task);
        a.start();
        MyThread2 b=new MyThread2(task);
        b.start();
        Thread.sleep(10000);
        long beginTime=MyCommonUtils.beginTime1;
        if(MyCommonUtils.beginTime2 < MyCommonUtils.beginTime1){
            beginTime=MyCommonUtils.beginTime2;
        }

        long endTime=MyCommonUtils.endTime1;
        if(MyCommonUtils.endTime2 > MyCommonUtils.endTime1){
            endTime=MyCommonUtils.endTime2;
        }
        System.out.println("耗时："+((endTime-beginTime)/1000));
    }

}

class MyThread1 extends Thread{
    private A2_1同步语句块 task;
    public MyThread1(A2_1同步语句块 task){
        this.task=task;
    }

    @Override
    public void run() {
        MyCommonUtils.beginTime1=System.currentTimeMillis();
        task.doLongTimeTask();
        MyCommonUtils.endTime1=System.currentTimeMillis();
    }
}
class MyThread2 extends Thread{
    private A2_1同步语句块 task;
    public MyThread2(A2_1同步语句块 task){
        this.task=task;
    }

    @Override
    public void run() {
        MyCommonUtils.beginTime2=System.currentTimeMillis();
        task.doLongTimeTask();
        MyCommonUtils.endTime2=System.currentTimeMillis();
    }
}
