package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-08-31 19:33
 * @desc:
 */
public class CountOperate extends Thread{

    public CountOperate(){
        System.out.println("构造方法-currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("构造方法-this.getName()="+this.getName());
    }

    @Override
    public void run() {
        System.out.println("run方法-currentThread().getName()="+Thread.currentThread().getName());
        System.out.println("run方法-this.getName()="+this.getName());
    }

    public static void main(String[] args) {
        CountOperate countOperate=new CountOperate();

//        countOperate.start();
        //输出结果：
//        构造方法-currentThread().getName()=main
//        构造方法-this.getName()=Thread-0
//        run方法-currentThread().getName()=Thread-0
//        run方法-this.getName()=Thread-0


        Thread thread=new Thread(countOperate);
        thread.setName("A");
        thread.start();
    }
}
