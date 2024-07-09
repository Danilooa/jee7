package br.com.danilooa.ocpjadee7.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.*;

@Stateless
public class ReceivingFromQueueUsingJmsConsumer {

    @Resource(mappedName = "java:/JmsXA")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/queue/MyQueue")
    private Queue queue;

    public void waitToMessage() {
        try (JMSContext context = connectionFactory.createContext();) {
            JMSConsumer consumer = context.createConsumer(queue);
            System.out.println("ReceivingFromQueueUsingJmsConsumer: " + consumer.receive());
        }
    }

}
