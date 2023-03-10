import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        List<Node> nos = new ArrayList<>();

        Node n1 = new Node(0, 0);
        Node n2 = new Node(1, 0);
        Node n3 = new Node(2, 2);
        Node n4 = new Node(3, 2);
        Node n5 = new Node(17, 23);
        Node n6 = new Node(12, 6);
        Node n7 = new Node(9, 24);
        Node n8 = new Node(18, 0);
        Node n9 = new Node(5, 3);

        nos = Arrays.asList(n1, n2, n3, n4, n5, n6, n7, n8, n9);
        //INICIA O DOUBLE NO MAIOR POSSIVEL
        double menorTotal = Double.MAX_VALUE;
        List<Pair> values = new ArrayList<>();
        for (int i = 0; i < nos.size() - 1; i++) {
            double menorTemp = 0;//AUX
            String nIndex1 = "n" + (Integer.toString(i + 1)), nindex2 = "";//STRING COM NOME DOS NÓS
            for (int j = i + 1; j < nos.size(); j++) {
                //SERVE PARA EXIBIR FUTURAMENTE
                nindex2 = "n" + (j + 1);
                //CALCULANDO A DISTANCIA
                Double dbp = Dbp(nos.get(i).getX(), nos.get(i).getY(), nos.get(j).getX(), nos.get(j).getY());
                System.out.println("Distancia entre n" + (i + 1) + " e n" + (j + 1) + ": " + dbp);
                // coloca no vetor de pares
                values.add(new Pair(nIndex1, nindex2, dbp));
                if (dbp < menorTotal) {
                    menorTotal = dbp;
                }
                // ESTAS LINHAS ABAIXO SERVEM APENAS PARA VIZUALIZAR O CÓDIGO E OS VALORES DURANTE A EXECUÇÃO, ELAS VERIFICAM SE DURANTE A ITERAÇÃO QUAL É O MENOR PARA AQUE PAR
                if (menorTemp == 0) {
                    menorTemp = dbp;

                } else if (dbp <= menorTemp) {
                    menorTemp = dbp;
                }

            }
            System.out.println("===================================================");
            System.out.println("menor distancia do nó n" + (i + 1) + " é ->" + "[" + nIndex1 + "," + nindex2 + "]" + ": "
            + menorTemp);
            System.out.println("===================================================");
        }
        System.out.println("");
        System.out.println("####################################################");
        System.out.println("menor total: " + menorTotal);
        System.out.println("===================================================");
        System.out.println("Pares que tem a menor distancia: ");
        //esse for mostra somente os elementos que são a menor distancia
        for (int e = 0; e < values.size(); e++) {
            if (menorTotal == values.get(e).distance) {
                System.out.println(values.get(e));
            }
        }
    }
    //Equaçãp de distancia entre pontos
    public static double Dbp(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }

    static class Pair {
        public String node1, node2;
        public Double distance;

        public Pair(String node1, String node2, Double distance) {
            this.node1 = node1;
            this.node2 = node2;
            this.distance = distance;
        }
        @Override
        public String toString() {
            return this.node1 + " " + this.node2 + " " + this.distance;
        }
    }
}
