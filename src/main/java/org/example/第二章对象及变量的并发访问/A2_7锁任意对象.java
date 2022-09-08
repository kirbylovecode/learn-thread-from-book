package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-01 22:30
 * @desc:
 */
public class A2_7锁任意对象 {
    private String userNameP;
    private String pwdP;
    private String anyStr=new String();
    public void setUserNamePwd(String userName,String pwd){
        try {
            //如果解开下面一行，说明是锁的不是同一个对象，会变成异步！
//            String anyStr=new String();
            synchronized (anyStr){
                System.out.println("名字="+Thread.currentThread().getName()+" 进入同步块时间： "+System.currentTimeMillis());
                userNameP=userName;
                Thread.sleep(3000);
                pwdP=pwd;
                System.out.println("名字="+Thread.currentThread().getName()+" 离开同步块时间： "+System.currentTimeMillis());

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        A2_7锁任意对象 task=new A2_7锁任意对象();
        Thread锁任意对象1 a=new Thread锁任意对象1(task);
        a.setName("A");
        a.start();
        Thread锁任意对象2 b=new Thread锁任意对象2(task);
        b.setName("B");
        b.start();

    }

}

class Thread锁任意对象1 extends Thread{
    private A2_7锁任意对象 service;
    public Thread锁任意对象1(A2_7锁任意对象 service){
        this.service=service;
    }

    @Override
    public void run() {
        service.setUserNamePwd("a","aa");
    }
}
class Thread锁任意对象2 extends Thread{
    private A2_7锁任意对象 service;
    public Thread锁任意对象2(A2_7锁任意对象 service){
        this.service=service;
    }

    @Override
    public void run() {
        service.setUserNamePwd("b","bb");
    }
}