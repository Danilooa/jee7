package br.com.danilooa.ocpjadee7.websocket.decoders;

import br.com.danilooa.ocpjadee7.websocket.TextMessage;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;

public class TextDecoder implements Decoder.Text<TextMessage> {
    @Override
    public TextMessage decode(String input) throws DecodeException {
        String[] parts = input.split(":");
        return new TextMessage(Long.valueOf(parts[1]), parts[2]);
    }

    @Override
    public boolean willDecode(String input) {
        if (input == null) {
            return false;
        }
        String regexStartsWithTextMessage = "^textMessage:.*"; // ^ asserts position at start of the string
        return input.matches(regexStartsWithTextMessage);
    }
}
