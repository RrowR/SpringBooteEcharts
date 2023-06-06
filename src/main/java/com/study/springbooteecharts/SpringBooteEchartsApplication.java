package com.study.springbooteecharts;

import com.study.springbooteecharts.kafka.ConsumerData;
import com.study.springbooteecharts.kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

@SpringBootApplication
public class SpringBooteEchartsApplication {

    static LinkedBlockingQueue<String> queue;

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBooteEchartsApplication.class, args);

        Producer producer = context.getBean(Producer.class);
        queue = producer.getQueue();
        producer.produce("开始");

        ConsumerData consumerData = new ConsumerData(queue);
        consumerData.startProcessing();


    }

}
