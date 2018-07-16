package com.wym;

import com.wym.consumer.MsgConsumer;
import com.wym.producer.MsgProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class KafkaApplication{
	public static void main(String[] args) {
		ApplicationContext app =
				SpringApplication.run(KafkaApplication.class, args);
		//生产者
//		new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				MsgProducer pro = app.getBean(MsgProducer.class);
//				pro.send();
//				try {
//					Thread.sleep(500);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		}).start();

		//消费者
		new Thread(new Runnable() {

			@Override
			public void run() {
				MsgConsumer customer = app.getBean(MsgConsumer.class);
				customer.user();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
