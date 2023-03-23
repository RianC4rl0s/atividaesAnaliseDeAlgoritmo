import java.util.Scanner;

public class Main {
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited = new boolean[5][5];
    static int[][] maze = new int[5][5];

    public static boolean val(int i, int j) {
        return i >= 0 && i < 5 && j >= 0 && j < 5 && maze[i][j] == 0 && !visited[i][j];
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;
        if (i == 4 && j == 4) return;
        for (int l = 0 ; l < 4; ++l) {
            if (val(i + dir[l][0], j + dir[l][1])) {
                dfs(i + dir[l][0], j + dir[l][1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();

        while (t-- > 0) {
            for (int i = 0 ; i < 5; ++i) {
                for (int j = 0 ; j < 5; ++j) {
                    maze[i][j] = sc.nextInt();
                }
            }

            visited = new boolean[5][5];
            dfs(0,0);

            if (visited[4][4]) {
                System.out.println("COPS");
            } else {
                System.out.println("ROBBERS");
            }
        }

        sc.close();
    }
}
//    O algoritmo utiliza a busca em profundidade (DFS) para percorrer o labirinto e verificar se os policiais conseguem
//    alcançar a posição dos ladrões. A cada iteração, o algoritmo visita um nó e verifica se pode se mover para um de seus
//    vizinhos (quando este está aberto). Quando a posição final é alcançada, a execução é encerrada. No final, é verificado
//    se a posição final foi alcançada e, consequentemente, se os policiais conseguiram capturar os ladrões.