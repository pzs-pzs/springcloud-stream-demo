package com.example.demo.consumer;

import com.example.demo.MyProcessor;
import com.example.demo.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;

@Slf4j
@EnableBinding({Processor.class, MyProcessor.class})
public class ConsumerDemo {

    @StreamListener(Processor.INPUT)
    public void receive(User user) {
        log.info("this is a default channel and the receive user is {}", user.toString());
    }


    @StreamListener(MyProcessor.MSG_RECEIVER)
    public void receive1(User user) {
        log.info("this is a customized channel and the receive user is {}", user.toString());
    }


}
