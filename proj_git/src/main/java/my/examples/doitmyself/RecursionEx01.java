package my.examples.doitmyself;

public class RecursionEx01 {
    public static void main(String[] args) {

    }
    int search(int[] data, int n, int target) {
        for(int i = 0; i < n ; i++){
            if(data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
