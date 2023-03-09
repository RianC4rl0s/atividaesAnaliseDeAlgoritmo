import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);

        int tests = Integer.parseInt(in.readLine());

        for (int x = 0; x < tests; x++) {
            int length = Integer.parseInt(in.readLine());
            String[] wagons = in.readLine().split(" ");

            String temp;
            int swaps = 0;
            for(int i = 0; i < length; i++){
                for(int j = 1; j < (length - i); j++){
                    if(Integer.parseInt(wagons[j-1]) > Integer.parseInt(wagons[j])){
                        temp = wagons[j - 1];
                        wagons[j - 1] = wagons[j];
                        wagons[j] = temp;

                        swaps++;
                    }
                }
            }

            System.out.println("Optimal train swapping takes " + swaps + " swaps.");
        }
    }
}