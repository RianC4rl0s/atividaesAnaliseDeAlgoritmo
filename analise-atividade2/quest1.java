import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

class Combination {
    ArrayList<Integer> id = new ArrayList<Integer>(); //ID da combinação
    ArrayList<Double> v = new ArrayList<Double>(); //Valores dos Items da Combinação
    ArrayList<Double> w = new ArrayList<Double>(); //Pesos dos Items da Combinação
    double we = 0, va = 0;

    public double totalWeight(){
        for (int i =  0; i < w.size(); i++){
            we += w.get(i);
        }
        return we;
    }

    public double totalValue(){
        for (int i =  0; i < v.size(); i++){
            va += v.get(i);
        }
        return va;
    }
}

public class quest1 {
    
    public static boolean verify(ArrayList<Integer> vet, ArrayList<Combination> combis){
        for (int i = 0; i < combis.size(); i++) {
            if(vet.equals(combis.get(i).id)){
                return false;
            }
        }
        return true;
    }

    public static Combination restartArray(Combination vet, ArrayList<Integer> oldVet, ArrayList<Double> oldV, ArrayList<Double> oldW) {

        for (int i = 0; i < oldVet.size();  i++){
            vet.id.add(oldVet.get(i));
            vet.v.add(oldV.get(i));
            vet.w.add(oldW.get(i));
        }

        return vet;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.println("Digite a capacidade da mochila: ");
        double capacity = sc.nextDouble();

        System.out.println("Digite a quantidade de items a serem analisados: ");
        int items = sc.nextInt();

        ArrayList<Double> values = new ArrayList<Double>();
        ArrayList<Double> weights = new ArrayList<Double>();
        ArrayList<Combination> combinations = new ArrayList<Combination>();

        double value = 0.0;
        double weight = 0.0;
        for (int i = 0; i < items; i++) {
            
            value = r.nextInt(50);
            while (value == 0.0) {
                value = r.nextInt(50);
            }
            weight = r.nextInt(15);
            while (weight == 0.0) {
                weight = r.nextInt(15);
            }

            values.add(value);
            weights.add(weight);
        }

        Combination aux;
        for (int i = 0; i < items; i++){
            aux = new Combination();
            aux.id.add(i);
            aux.v.add(values.get(i));
            aux.w.add(weights.get(i));
            combinations.add(aux);
        }

        for (int i = 0; i < combinations.size(); i++) {
            aux = new Combination();
            aux = restartArray(aux, combinations.get(i).id, combinations.get(i).v, combinations.get(i).w);
            for (int j = 0; j < items; j++){
                if (!aux.id.contains(j)) {
                    aux.id.add(j);
                    aux.v.add(values.get(j));
                    aux.w.add(weights.get(j));
                    aux.id.sort(Comparator.naturalOrder());
                }
                if (verify(aux.id, combinations)){
                    combinations.add(aux);
                }
                aux = new Combination();
                aux = restartArray(aux, combinations.get(i).id, combinations.get(i).v, combinations.get(i).w);
            }
        }     
        

        int pos = 0;
        double maxValue = 0;
        double maxWeight = 0;

        for (int i = 0; i < combinations.size(); i++) {
            if ((combinations.get(i).totalValue() > maxValue) && (combinations.get(i).totalWeight() <= capacity)){
                pos = i;
                maxValue = combinations.get(i).va;
                maxWeight = combinations.get(i).we;
            }
        }
        
        System.out.println("Items:" + values);
        System.out.println("Pesos:" + weights);
        System.out.println("Produtos adicionados: " + combinations.get(pos).id);
        System.out.println("Valores: " + combinations.get(pos).v);
        System.out.println("Pesos: " + combinations.get(pos).w);
        System.out.println("Valor Total: " + combinations.get(pos).va);
        System.out.println("Peso Total: " + combinations.get(pos).we);

    }
}
