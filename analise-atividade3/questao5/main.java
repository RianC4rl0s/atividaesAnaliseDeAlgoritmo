import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int f=0;
    public boolean compara(int x, int y){ // declaro a função bool compara, que recebe dois inteiros
        if(x>y) return true;
        return false;
    }

    public static int binarySeach(int d, int s, int[] vetor) {
        int  l, m, achou;
        l = s - 1; achou = 0;
        while (f <= l) {
            m = (f + l) / 2;
            if (d <= vetor[m]) {
                l = m - 1;
            }else if (d > vetor[m]) {
                achou = 1;
                f++;
                break;
            };
        }
        if (achou !=0)
            return 1;
        else
            return 2;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(ir);
        int cont=0;
        String ctd = in.readLine();
        int[] qi = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] ni = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(qi);
        Arrays.sort(ni);

        for (int i=0; i<Integer.parseInt(ctd); i++){
            int k= binarySeach(ni[i],Integer.parseInt(ctd),qi);
            if(k==1)
                cont++;
        }
        System.out.println(cont);

    }
}