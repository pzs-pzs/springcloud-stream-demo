package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableBinding({Processor.class,MyProcessor.class})
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @StreamListener(Processor.INPUT)
    public void receive(String payload){

        System.out.println("received： "+payload);

    }

//    @StreamListener(MyProcessor.MSG_RECEIVER)
//    public void re(String p) {
////        System.out.println("P"+p);
//    }


    @Autowired
    Processor processor;

    @RequestMapping("/test")
    public void test(){
        processor.output().send(MessageBuilder.withPayload("GUA pi").build());
        myProcessor.msgSender().send(MessageBuilder.withPayload("GUA piaa").build());

    }

    @Autowired
    MyProcessor myProcessor;


}
