package my.examples.was03;

public class Main {
    public static void main(String[] args) {
        Connector connector = new Connector(8888);
        connector.start();
        System.out.println("Mini WAS start!");
    }
}
