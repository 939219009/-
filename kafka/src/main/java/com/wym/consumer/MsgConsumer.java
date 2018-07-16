package com.wym.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Properties;

@Component
public class MsgConsumer {
    //以下读取消费者属性值
    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String servers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;


    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String   autoOffsetReset;

    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private String  enableAutoCommit;


    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private String  autoCommitInterval;


    @Value("${spring.kafka.consumer.key-deserializer}")
    private String  keyDeserializer;


    @Value("${spring.kafka.consumer.value-deserializer}")
    private String  valueDeserializer;

    @Value("${spring.kafka.consumer.session-timeout-ms}")
    private String  sessionTimeoutMs;


    private KafkaConsumer<String,String > consumer;
    //创建卡夫卡对象
    public KafkaConsumer<String,String > createConsumer(){
        Properties properties=new Properties();
        properties.put("bootstrap.servers",this.servers);
        properties.put("group.id",this.groupId);
        properties.put("auto.offset.reset",this.autoOffsetReset);
        properties.put("enable.auto.commit",this.enableAutoCommit);
        properties.put("key.deserializer",this.keyDeserializer);
        properties.put("value.deserializer",this.valueDeserializer);
        properties.put("session.timeout.ms",this.sessionTimeoutMs);

        consumer=new KafkaConsumer<String,String >(properties);
        return consumer;
    }
    public void user(){
        KafkaConsumer<String,String > consumer=this.createConsumer();
        //订阅主题
        consumer.subscribe(Arrays.asList("wymmsg"));

        while(true){
            ConsumerRecords<String, String> crs=consumer.poll(100);
            for(ConsumerRecord<String,String> cr :crs){
                System.out.println("你消费的记录是"+cr.key()+"------------"+cr.value());

            }
            consumer.commitSync();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
