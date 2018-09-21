package my.examples.was03;

public class ClassLoaderTest01 {
    public static void main(String[] args) throws Exception {
        Sample s1 = new Sample();
        s1.print();
        s1.print("world!");
        System.out.println("-----");

    }
}
