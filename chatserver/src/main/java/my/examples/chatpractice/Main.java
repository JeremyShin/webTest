package my.examples.chatpractice;

public class Main {
    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer(11002);
        chatServer.start();
    }
}
