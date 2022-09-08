package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-02 11:10
 * @desc:
 */
public class A2_11死锁 {

    public synchronized void methodA(){
        System.out.println("方法a开始");
        boolean a=true;
        while (a){

        }
        System.out.println("方法a结束");

    }

    public synchronized void methodB(){
        System.out.println("方法B开始");
        System.out.println("方法B结束");
    }

    public static void main(String[] args) {
        A2_11死锁 obj=new A2_11死锁();
        Thread2_11_1 a=new Thread2_11_1(obj);
        a.start();
        Thread2_11_2 b=new Thread2_11_2(obj);
        b.start();


    }
}

class Thread2_11_1 extends Thread{
    private A2_11死锁 obj;
    public Thread2_11_1(A2_11死锁 obj){
        this.obj=obj;
    }

    @Override
    public void run() {
        obj.methodA();
    }
}
class Thread2_11_2 extends Thread{
    private A2_11死锁 obj;
    public Thread2_11_2(A2_11死锁 obj){
        this.obj=obj;
    }

    @Override
    public void run() {
        obj.methodB();
    }
}
