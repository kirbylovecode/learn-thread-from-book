package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-09-01 9:03
 * @desc:
 */
public class 暂停线程 extends Thread{
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true){
            i++;
        }
    }


    public static void main(String[] args) throws Exception{
        暂停线程 thread=new 暂停线程();
        thread.start();
        Thread.sleep(5000);
        //A
        thread.suspend();
        System.out.println("a="+System.currentTimeMillis()+"  i="+thread.getI());
        Thread.sleep(5000);
        System.out.println("a="+System.currentTimeMillis()+"  i="+thread.getI());

        //B
        thread.resume();
        Thread.sleep(5000);
        //c
        thread.suspend();
        System.out.println("b="+System.currentTimeMillis()+"  i="+thread.getI());
        Thread.sleep(5000);
        System.out.println("b="+System.currentTimeMillis()+"  i="+thread.getI());



    }
}
