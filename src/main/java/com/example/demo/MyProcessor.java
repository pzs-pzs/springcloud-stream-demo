package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {

    String MSG_RECEIVER = "msgReceiver"; // 通道名

    @Input(MyProcessor.MSG_RECEIVER)
    SubscribableChannel msgReceiver();

    String MSG_SENDER = "msgSender"; // 通道名

    @Output(MyProcessor.MSG_SENDER)
    MessageChannel msgSender();
}
