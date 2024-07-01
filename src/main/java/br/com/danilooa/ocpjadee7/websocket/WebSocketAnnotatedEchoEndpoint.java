package br.com.danilooa.ocpjadee7.websocket;

import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;

@ServerEndpoint("/annotated/echo")
public class WebSocketAnnotatedEchoEndpoint {
    @OnMessage
    public void onMessage(Session session, String msg) {
        try {
            session.getBasicRemote().sendText("annotated " + msg);
        } catch (IOException e) {

        }
    }
}
