package br.com.danilooa.ocpjadee7.websocket.enconder;

import br.com.danilooa.ocpjadee7.websocket.TextMessage;
import jakarta.websocket.EncodeException;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint(
        value = "/textEncoded/echo",
        encoders = {TextEncoder.class}
)
public class WebSocketTextEncoded {
    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            TextMessage textMessage = new TextMessage(1L, "annotated text encoded");
            session.getBasicRemote().sendObject(textMessage);
        } catch (EncodeException | IOException e) {
            System.out.println("There was an error: " + e.getMessage());
        }
    }
}
