package com.study.springbooteecharts.kafka;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author: Rrow
 * @date: 2023/6/7 1:02
 * Description:
 */
@Component
public class Producer {
    int i = 0;

    private LinkedBlockingQueue<String> queue;

    public Producer() {
        this.queue = new LinkedBlockingQueue<>(100);
    }


    public void produce(String message) throws InterruptedException {
        Runnable runnable = () -> {
            while (true) {
                try {
                    queue.put("message = " + i++);
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public LinkedBlockingQueue<String> getQueue() {
        return queue;
    }

    public void setQueue(LinkedBlockingQueue<String> queue) {
        this.queue = queue;
    }
}
