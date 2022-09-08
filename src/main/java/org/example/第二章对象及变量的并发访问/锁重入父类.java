package org.example.第二章对象及变量的并发访问;

/**
 * @author: joe
 * @date: 2022-09-01 19:12
 * @desc:
 */
public class 锁重入父类 {

    public int i=10;
    synchronized public void operateMainMethod(){
        try {
            i--;
            System.out.println("main print i="+i);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
