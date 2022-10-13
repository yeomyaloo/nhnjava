package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.greeting.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import javax.swing.Spring;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {MainConfig.class})
public class MessageService {

    @Autowired
    private MessageSenderService messageSenderService;

    private SmsMessageSender messageSender;


    @Test
    public void test(){
        messageSenderService.setMessageSender(messageSender);
    }


}
