public class SubsetSum {
    public static boolean existeSubconjuntoSoma(int n, int s, int[] tamanhos) {
        boolean[][] dp = new boolean[n + 1][s + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true; // Um subconjunto vazio sempre terá soma igual a zero
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                dp[i][j] = dp[i - 1][j]; // Se não incluirmos o item atual, a soma não muda
                if (tamanhos[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - tamanhos[i - 1]];
                } // Se pudermos incluir o item atual, tentamos incluí-lo
            }
        }
        return dp[n][s]; // O valor na última célula da matriz indicará se existe um subconjunto com a soma exata S
    }

    public static void main(String[] args) {
        int[] tamanhos = { 2, 3, 5, 7, 10 }; // Exemplo de array de tamanhos
        int s = 14; // Exemplo de soma desejada
        int n = tamanhos.length; // Número de itens
        boolean existe = existeSubconjuntoSoma(n, s, tamanhos);
        if (existe) {
            System.out.println("Existe um subconjunto com soma exata " + s);
        } else {
            System.out.println("Não existe um subconjunto com soma exata " + s);
        }
    }
}