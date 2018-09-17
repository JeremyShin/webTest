package my.examples.chatpractice4;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(11000);
        chatServer.start();
    }
}
