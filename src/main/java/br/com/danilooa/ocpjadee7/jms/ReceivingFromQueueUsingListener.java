package br.com.danilooa.ocpjadee7.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Stateless;
import jakarta.jms.*;

@Stateless
public class ReceivingFromQueueUsingListener {

    @Resource(mappedName = "java:/JmsXA")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "java:/jms/queue/MyQueue")
    private Queue queue;

    public void waitToMessage() throws JMSException{
        try (JMSContext context = connectionFactory.createContext();) {
            JMSConsumer consumer = context.createConsumer(queue);
            //consumer.setMessageListener(new MyJmsListener());

            Message message = consumer.receive();
            /*
            You can use the receiveBody method to receive any type of message except
            StreamMessage and Message, as long as the body of the message can be assigned to a
            particular type.
             */
            Message message2 = consumer.receiveBody(BytesMessage.class);

            if (message instanceof TextMessage) {
                String messageBody = message.getBody(String.class);

                System.out.println("Reading message: " + message);
            } else {
                // Handle error or process another message type
            }

        }
    }

}
