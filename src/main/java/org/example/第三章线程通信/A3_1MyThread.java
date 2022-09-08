package org.example.第三章线程通信;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: joe
 * @date: 2022-09-03 11:12
 * @desc:
 */
public class A3_1MyThread {
}
class MyList{
    private List list=new ArrayList();
    public void add(){
        list.add("123");
    }
    public int size(){
        return list.size();
    }

    public static void main(String[] args) {
        MyList list=new MyList();
        Thread3_1_1 a=new Thread3_1_1(list);
        a.setName("A");
        a.start();
        Thread3_1_2 b=new Thread3_1_2(list);
        b.setName("B");
        b.start();
    }

}

class Thread3_1_1 extends Thread{
    private MyList list;

    public Thread3_1_1(MyList list){
        this.list=list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add();
                System.out.println("添加了 "+(i+1) +" 个元素");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Thread3_1_2 extends Thread{
    private MyList list;

    public Thread3_1_2(MyList list){
        this.list=list;
    }

    @Override
    public void run() {
        try {
            while (true){
                if(list.size() == 5){
                    System.out.println("==5了 B退出");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}