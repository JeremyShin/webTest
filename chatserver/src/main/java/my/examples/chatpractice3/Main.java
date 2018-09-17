package my.examples.chatpractice3;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(11003);
        chatServer.start();
    }
}
