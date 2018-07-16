package com.wym.producer;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgProducer {
    @Autowired
    private KafkaTemplate<String,String> tmp;
    public void send(){
        int i=0;
        while(true){
            String topic="wymmsg";
            String value="Test"+(++i);
            String key="article-"+value.hashCode();
            String json= JSON.toJSONString(value);
            tmp.send(topic,key,value);
        }

    }
}
