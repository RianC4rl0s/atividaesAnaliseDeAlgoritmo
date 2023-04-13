import java.util.Scanner;

public class questao6 {

    public static void main(String[] args) {
        int MOD = 1000000007;
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt(); //tempo
        int M = sc.nextInt(); //dificuldade minima
        int N = sc.nextInt(); //dificuldade maxima

        sc.close();

        int[][] DP = new int[T+1][N+1];
        for (int i = M; i <= N; i++) {
            DP[1][i] = 1; //como o tempo é 1, então o exercicio se torna muito curto, só podendo utilizar 1 tipo de dificuldade
        }

        for (int i = 2; i <= T; i++) { //percorrer a matriz a partir dos 2 minutos
            for (int j = M; j <= N; j++) {
                if (j == M) {
                    DP[i][j] = DP[i-1][j+1]; //+1 para não adicionar um nivel de dificuldade menor que M
                } else if (j == N) {
                    DP[i][j] = DP[i-1][j-1]; //-1 para não adicionar um nivel de dificuldade maior que N
                } else {
                    DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % MOD; //todas as outras possibilidades seguem o mesmo padrão
                }
            }
        }

        int resultado = 0;
        for (int i = M; i <= N; i++) {
            resultado = (resultado + DP[T][i]) % MOD; //verificando a quantidade possivel de resultados
        }

        System.out.println(resultado);
    }
}
