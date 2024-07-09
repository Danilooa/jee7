package br.com.danilooa.ocpjadee7.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jms.*;

@Stateless
public class SendingToQueueUsingJmsProducer {

    @Resource(mappedName = "java:/JmsXA")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/queue/MyQueue")
    private Queue queue;

    private Topic topic;
    public void sendMessage(String message) {
        try (JMSContext context = connectionFactory.createContext();) {
            context.createProducer().send(queue, message);
            System.out.println("SendingToQueueUsingJmsProducer: " + message);


            JMSConsumer consumer = context.createConsumer(topic);
            JMSConsumer sharedConsumer = context.createSharedConsumer(topic, "idClient");
            JMSConsumer durableConsumer = context.createDurableConsumer(topic, "idClient");
            JMSConsumer durableSharedConsumer = context.createSharedDurableConsumer(topic, "idClient");
        }
        
        
    }
}