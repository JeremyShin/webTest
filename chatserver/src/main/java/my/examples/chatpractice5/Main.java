package my.examples.chatpractice5;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(11004);
        chatServer.start();
    }
}
