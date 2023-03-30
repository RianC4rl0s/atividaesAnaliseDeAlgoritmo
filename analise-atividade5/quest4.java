import java.util.Scanner;
import java.util.ArrayList;

public class quest4 {
    static ArrayList<Integer> valores = new ArrayList<Integer>();
    static int win = 0;

    public static void inverterPosicao(int pos1, int pos2){
        if (valores.get(pos1) > valores.get(pos2)) {
            int aux = valores.get(pos1);
            valores.set(pos1, valores.get(pos2));
            valores.set(pos2, aux);
            win++;
            inverterPosicao(0, 1);
        } else if ((pos2 + 1) < valores.size()) {
            inverterPosicao(pos1+1, pos2+1);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            int quant = sc.nextInt();

            if (quant >= 2) {
                for (int i = 0; i < quant; i++){
                    valores.add(sc.nextInt());
                }
        
                inverterPosicao(0,1);
        
                if (win%2 == 0) {
                    System.out.println("Carlos");
                } else {
                    System.out.println("Marcelo");
                }
                win = 0;
            }
            
        }
        
    }

}
