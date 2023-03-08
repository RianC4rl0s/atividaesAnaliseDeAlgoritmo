import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class App {
    public static void main(String[] args) throws Exception {
        List<Node> nos = new ArrayList<>();

        Node n1 = new Node(10, 4);
        Node n2 = new Node(5, 3);
        Node n3 = new Node(7, 2);
        Node n4 = new Node(8, -1);
        Node n5 = new Node(17, 23);
        Node n6 = new Node(12, 6);
        Node n7 = new Node(9, 24);
        Node n8 = new Node(18, 0);
        
        nos = Arrays.asList(n1, n2, n3, n4, n5,n6,n7,n8);
        for (int i = 0; i < nos.size() - 1; i++) {
            double menorTemp = 0;
            String nIndex1 = "n" + (Integer.toString(i + 1)), nindex2 = "";
            for (int j = i; j < nos.size(); j++) {
                if (i != j) {
                    System.out.println("=========================================");
                    System.out.println("Distancia entre n" + (i + 1) + " e n" + (j + 1));
                    Double dbp = Dbp(nos.get(i).getX(), nos.get(i).getY(), nos.get(j).getX(), nos.get(j).getY());
                    System.out.println(dbp);
                    if (menorTemp == 0) {
                        menorTemp = dbp;
                        nindex2 = "n" + (j + 1);
                    } else if (dbp <= menorTemp) {
                        menorTemp = dbp;
                        nindex2 = "n" + (j + 1);
                    }

                }
            }
            System.out.println("===================================================");
            System.out.println("menor distancia do nó n" + (i + 1) + " é :");
            System.out.println("[" + nIndex1 + "," + nindex2 + "]" + ": " + menorTemp);
        }
    }

    public static double Dbp(int x1, int y1, int x2, int y2) {
        return Math.sqrt((Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)));
    }
    static class Pair{
        public String node1, node2;
        public Double distance;
        public Pair(String node1, String node2, Double distance){
            this.node1 = node1;
            this.node2 = node2;
            this.distance = distance;
        }
    }
}
