package org.example.第二章对象及变量的并发访问;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author: joe
 * @date: 2022-09-02 9:04
 * @desc:
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws Exception{
        CountDownLatch latch = new CountDownLatch(10);

        for (int i=0; i<=9; i++) {
            CountDownLatchThread thread=new CountDownLatchThread(latch);
            thread.start();
        }

        System.out.println("等待子线程运行结束");
//        latch.await(10, TimeUnit.SECONDS);
        latch.await();
        System.out.println("子线程运行结束");

    }
}

class CountDownLatchThread extends Thread{
    CountDownLatch latch;

    public  CountDownLatchThread(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 运行");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }

}
