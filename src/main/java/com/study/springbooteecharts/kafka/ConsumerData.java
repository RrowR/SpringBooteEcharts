package com.study.springbooteecharts.kafka;

import java.util.concurrent.*;

/**
 * @author: Rrow
 * @date: 2023/6/7 1:36
 * Description:
 */
public class ConsumerData {

    private LinkedBlockingQueue dataQueue;

    private ExecutorService executorService;

    public ConsumerData(LinkedBlockingQueue dataDueue) {
        this.dataQueue = dataDueue;
        this.executorService = Executors.newFixedThreadPool(5);
    }

    public void startProcessing() {
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Worker());
        }
    }


    private class Worker implements Runnable {
        @Override
        public void run() {
            while (true) {
                String data = null;
                try {
                    Thread.sleep(140);
                    data = (String) dataQueue.take();
                    if (data != null) {
                        System.out.println("消费了 = " + data + " 队列大小剩余 = " + dataQueue.size());
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }


}
