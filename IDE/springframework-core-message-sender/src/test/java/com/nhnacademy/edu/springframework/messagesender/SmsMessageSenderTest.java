package com.nhnacademy.edu.springframework.messagesender;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.nhnacademy.edu.springframework.messagesender.service.SmsMessageSender;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

class SmsMessageSenderTest {



    SmsMessageSender smsMessageSender = new SmsMessageSender();
    MessageSenderService messageSenderService = new MessageSenderService(smsMessageSender);

    @Test
    void testSmsSenderMessage(){
        ReflectionTestUtils.setField(messageSenderService, "messageSender", new SmsMessageSender());

        boolean actual = messageSenderService.sendMessage();

        Assertions.assertThat(actual).isTrue();

    }


}