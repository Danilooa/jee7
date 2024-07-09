package br.com.danilooa.ocpjadee7.jms;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;

public class MyJmsListener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        System.out.println("MyJmsListener: " + message);
    }
}
