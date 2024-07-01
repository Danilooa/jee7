package br.com.danilooa.ocpjadee7.websocket;

public class TextMessage {

    private Long id;
    private String name;

    public TextMessage(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
