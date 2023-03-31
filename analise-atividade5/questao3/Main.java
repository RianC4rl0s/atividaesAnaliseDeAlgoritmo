public class Main {

    // Método para calcular a soma máxima em um subvetor que cruza o meio do vetor
    private static int maxCrossingSum(int[] arr, int l, int m, int h) {
        // Calcula a soma máxima no subvetor que começa no meio e vai para a esquerda
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = m; i >= l; i--) {
            sum += arr[i];
            if (sum > leftSum)
                leftSum = sum;
        }

        // Calcula a soma máxima no subvetor que começa no meio e vai para a direita
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = m+1; i <= h; i++) {
            sum += arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }

        // Retorna a soma das duas somas máximas
        return leftSum + rightSum;
    }

    // Método recursivo para calcular a soma máxima em um subvetor de um vetor
    private static int maxSubArraySum(int[] arr, int l, int h) {
        // Caso base: quando o vetor tem apenas um elemento
        if (l == h) {
            return arr[l];
        }

        // Calcula o meio do vetor
        int m = (l + h) / 2;

        // Calcula a soma máxima em um subvetor que cruza o meio do vetor
        int maxCrossing = maxCrossingSum(arr, l, m, h);

        // Calcula a soma máxima em um subvetor da metade esquerda do vetor
        int maxLeft = maxSubArraySum(arr, l, m);

        // Calcula a soma máxima em um subvetor da metade direita do vetor
        int maxRight = maxSubArraySum(arr, m+1, h);

        // Retorna a maior soma encontrada entre os três casos
        return Math.max(Math.max(maxLeft, maxRight), maxCrossing);
    }

    public static void main(String[] args) {
        int[] arr = {2, -5, 7, 8, -10, 12};
        int n = arr.length;
        int maxSum = maxSubArraySum(arr, 0, n-1);
        System.out.println("A soma máxima em um subvetor do vetor dado é " + maxSum);
    }
}
