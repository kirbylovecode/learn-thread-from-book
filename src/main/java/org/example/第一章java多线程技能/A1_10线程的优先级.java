package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-09-01 10:28
 * @desc:
 */
public class A1_10线程的优先级 {

    public static void main(String[] args) {
        Thread thread1=new Thread(){
            @Override
            public void run() {
                System.out.println(1);
            }
        };


        thread1.setPriority(1);
    }
}
