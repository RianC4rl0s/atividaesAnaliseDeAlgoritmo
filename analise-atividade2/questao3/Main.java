import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        String[] input = in.readLine().split(" ");
        while (!input[0].equals("0")) {
            String temp;
            int swaps = 0;
            for(int i = 0; i < input.length; i++){
                for(int j = 1; j < (input.length); j++){
                    if(input[j-1].compareTo(input[j]) >= 0){
                        temp = input[j - 1];
                        input[j - 1] = input[j];
                        input[j] = temp;

                        swaps++;
                    }
                }
            }
            System.out.println(swaps % 2 == 0 ? "Carlos" : "Marcelo");
            input = in.readLine().split(" ");
        }
    }
}