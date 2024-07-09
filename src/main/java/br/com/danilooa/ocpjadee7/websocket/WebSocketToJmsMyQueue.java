package br.com.danilooa.ocpjadee7.websocket;

import br.com.danilooa.ocpjadee7.jms.JMSQueueProducer;
import br.com.danilooa.ocpjadee7.jms.SendingToQueueUsingJmsProducer;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.jms.JMSContext;
import jakarta.jms.JMSException;
import jakarta.jms.Queue;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint("/myQueue/echo")
public class WebSocketToJmsMyQueue {

    @Inject
    private JMSQueueProducer jmsQueueProducer;

    @Inject
    private SendingToQueueUsingJmsProducer sendingToQueueUsingJmsProducer;
    @OnMessage
    public void onMessage(Session session, String msg) throws JMSException {
        sendingToQueueUsingJmsProducer.sendMessage(msg);
        System.out.println("WebSocketToJmsMyQueue: " + msg);
    }
}
