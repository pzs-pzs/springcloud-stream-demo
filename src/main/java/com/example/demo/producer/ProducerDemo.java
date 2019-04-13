package com.example.demo.producer;

import com.example.demo.MyProcessor;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding({Processor.class, MyProcessor.class})
public class ProducerDemo {
    @Autowired
    Processor processor;

    @Autowired
    MyProcessor myProcessor;

    public void producer() {
        processor.output().send(MessageBuilder.withPayload(buildUser("userA", "pwdA")).build());
        myProcessor.msgSender().send(MessageBuilder.withPayload(buildUser("userB", "pwdB")).build());
    }

    private User buildUser(String username, String pwd) {
        User user = new User();
        user.setPassword(pwd);
        user.setUsername(username);
        return user;
    }


}
