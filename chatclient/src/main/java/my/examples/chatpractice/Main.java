package my.examples.chatpractice;

public class Main {
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient("127.0.0.1", 11001);
        chatClient.start();
    }
}
