package org.example.第一章java多线程技能;

/**
 * @author: joe
 * @date: 2022-08-31 21:35
 * @desc:
 */
public class Stop extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 1000; i++) {
                System.out.println("i="+(i+1));
                //如果线程被中断 则break
                if (this.isInterrupted()) {
                    throw new Exception();
                }
            }
            System.out.println("hhhhhh");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        Stop stop=new Stop();
        stop.start();
        Thread.sleep(1);
        stop.stop();
    }

}


