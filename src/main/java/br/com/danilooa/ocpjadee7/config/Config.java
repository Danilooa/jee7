package br.com.danilooa.ocpjadee7.config;

import br.com.danilooa.ocpjadee7.websocket.WebSocketProgrammaticEchoEndpoint;
import jakarta.websocket.Endpoint;
import jakarta.websocket.server.ServerApplicationConfig;
import jakarta.websocket.server.ServerEndpointConfig;

import java.util.Set;

public class Config implements ServerApplicationConfig {

    @Override
    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
        // Deploy all WebSocket endpoints found via scanning or specify your endpoint class
        return scanned;
    }

    @Override
    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
        // Register WebSocket endpoint programmatically
        ServerEndpointConfig endpointConfig = ServerEndpointConfig.Builder
                .create(WebSocketProgrammaticEchoEndpoint.class, "/programmatic/echo")
                .build();
        return Set.of(endpointConfig);
    }
}
