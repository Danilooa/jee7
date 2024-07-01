package br.com.danilooa.ocpjadee7.websocket.decoders;

import br.com.danilooa.ocpjadee7.websocket.TextMessage;
import br.com.danilooa.ocpjadee7.websocket.enconder.TextEncoder;
import jakarta.websocket.EncodeException;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint(
        value = "/textDecoded/echo",
        decoders = {TextDecoder.class}
)
public class WebSocketTextDecoded {
    @OnMessage
    public void onMessage(Session session, TextMessage message) {
        try {
            session.getBasicRemote().sendText(message.toString());
        } catch (IOException e) {
            System.out.println("There was an error: " + e.getMessage());
        }
    }
}
