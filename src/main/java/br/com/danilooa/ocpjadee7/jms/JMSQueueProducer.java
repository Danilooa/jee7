package br.com.danilooa.ocpjadee7.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.*;

@Stateless
public class JMSQueueProducer {

    @Inject
    private JMSContext jmsContext;

    @Resource(lookup = "java:/jms/queue/MyQueue")
    private Queue queue;

    public void sendMessage(String message2) throws JMSException {
        TextMessage jmsMessage = jmsContext.createTextMessage(message2);
        Message message = jmsContext.createMessage();
        //Message has no method to set a body

        TextMessage textMessage = jmsContext.createTextMessage();
        textMessage.setText("body");

        MapMessage mapMessage = jmsContext.createMapMessage();
        //mapMessage.set***Type***("parameterName", value);

        BytesMessage bytesMessage = jmsContext.createBytesMessage();
        bytesMessage.writeBytes(new byte[0]);

        ObjectMessage objectMessage = jmsContext.createObjectMessage();
        //objectMessage.setObject(SerializableObject);

        StreamMessage streamMessage = jmsContext.createStreamMessage();
        streamMessage.writeBytes(new byte[0]);


        jmsContext.createProducer().send(queue, jmsMessage);
        System.out.println("JMSQueueProducer: " + message);
    }
}