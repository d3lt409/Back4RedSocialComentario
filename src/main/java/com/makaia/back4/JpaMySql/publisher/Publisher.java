package com.makaia.back4.JpaMySql.publisher;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.makaia.back4.JpaMySql.dtos.NotificacionData;

@Component
@EnableRabbit
public class Publisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private MessageConverter jsonMessageConverter;

    public void send(Long emisor_id, Long notificado_id) {
        NotificacionData object = new NotificacionData(emisor_id, notificado_id);
        Message message = jsonMessageConverter.toMessage(object, new MessageProperties());
        this.rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
