import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.println("tamanho do baralho: ");
       int p = scanner.nextInt();
       
       int [] original = new int [p];
       for (int i = 1; i <= p; i++) {
            original[i - 1] = i;
       }

       boolean igual;
       int cont = 0;
       int [] baralho = original;

       do {
        cont++;
        int [] embaralhado = embaralhar(baralho, p);
        igual = comparar(original, embaralhado);
        baralho = embaralhado;
       } while (!igual);

       scanner.close();
       System.out.println(cont);
    }

    public static int [] embaralhar (int[] baralho, int p) {
        int [] b1 = slice(baralho, 0, p / 2);
        int [] b2 = slice(baralho, p / 2, p);
        
        int [] embaralhado = new int[p];

        for (int i = 0, j = 0; i < p / 2; i++) {
            embaralhado[j++] = b2[i];
            embaralhado[j++] = b1[i];
        }

        return embaralhado;
    }

    public static boolean comparar(int [] baralho, int [] embaralhado) {
        for (int i = 0; i < baralho.length; i++)
            if (baralho[i] != embaralhado[i])
                return false;
        
        return true;
    }

    public static int[] slice(int[] array, int startIndex, int endIndex) {
        int[] slicedArray = new int[endIndex - startIndex]; 
        for (int i = 0; i < slicedArray.length; i++)   {   
            slicedArray[i] = array[startIndex + i];   
        }
        return slicedArray;   
    }
}
