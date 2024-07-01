package br.com.danilooa.ocpjadee7.websocket.enconder;

import br.com.danilooa.ocpjadee7.websocket.TextMessage;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;

public class TextEncoder implements Encoder.Text<TextMessage> {

    @Override
    public String encode(TextMessage textMessage) throws EncodeException {
        return textMessage.getId() + ":" + textMessage.getName();
    }

}
