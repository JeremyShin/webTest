package my.examples.chatpractice;

import java.io.BufferedReader;

public class InputHandler extends Thread {
    BufferedReader in;

    public InputHandler(BufferedReader in) {
        this.in = in;
    }

    @Override
    public void run() {
        try{
            String line = null;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }
        }catch(Exception ex){
            System.out.println("ex : " + ex.getMessage());
    } finally {
            try{ in.close(); } catch (Exception e) {}
        }
        }
}
