package br.com.danilooa.ocpjadee7.websocket;

import br.com.danilooa.ocpjadee7.jaxb.JavaToXml;
import br.com.danilooa.ocpjadee7.jms.JMSQueueProducer;
import br.com.danilooa.ocpjadee7.jms.SendingToQueueUsingJmsProducer;
import jakarta.inject.Inject;
import jakarta.jms.JMSException;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

@ServerEndpoint("/jaxb")
public class WebSocketJaxB {

    @Inject
    private JMSQueueProducer jmsQueueProducer;

    @Inject
    private SendingToQueueUsingJmsProducer sendingToQueueUsingJmsProducer;

    @OnMessage
    public void onMessage(Session session, String msg) throws JMSException {
        try {
            new JavaToXml().marshal();
            System.out.println("WebSocketJaxB: " + msg);
        } catch (Exception e) {
            throw new JMSException(e.getMessage(), "none", e);
        }
    }
}
