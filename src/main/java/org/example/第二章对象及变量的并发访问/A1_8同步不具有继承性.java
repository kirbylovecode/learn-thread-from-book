package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-01 21:24
 * @desc:同步不具有继承性
 */
//父类
public class A1_8同步不具有继承性 {

    public synchronized void testMethod() {
        try {
            System.out.println("int main 下一步 sleep begin threadname=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int main 下一步 sleep end threadname=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        Sub sub=new Sub();
        Thread3 a=new Thread3(sub);
        a.setName("a");
        a.start();
        Thread4 b=new Thread4(sub);
        b.setName("b");
        b.start();


    }
}

//子类
class Sub extends A1_8同步不具有继承性{
    @Override
//    public synchronized void testMethod() {
    public void testMethod() {
        try {
            System.out.println("int sub 下一步 sleep begin threadname=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("int sub 下一步 sleep end threadname=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            super.testMethod();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Thread3 extends Thread{
    private Sub sub;
    public Thread3(Sub sub){
        this.sub=sub;
    }

    @Override
    public void run() {
        sub.testMethod();
    }
}


class Thread4 extends Thread{
    private Sub sub;
    public Thread4(Sub sub){
        this.sub=sub;
    }

    @Override
    public void run() {
        sub.testMethod();
    }
}