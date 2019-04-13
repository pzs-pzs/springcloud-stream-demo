package com.example.demo;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 *  自定义channel，必须是接口
 *  仿照SpringCloudStream Processor.java
 */
public interface MyProcessor {

    String MSG_RECEIVER = "msgReceiver"; // 通道名

    /**
     *  消息接收
     * @return
     */
    @Input(MyProcessor.MSG_RECEIVER)
    SubscribableChannel msgReceiver();

    String MSG_SENDER = "msgSender"; // 通道名

    /**
     * 消息发送
     * @return
     */
    @Output(MyProcessor.MSG_SENDER)
    MessageChannel msgSender();
}
