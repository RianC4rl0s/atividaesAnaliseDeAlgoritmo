import java.util.Scanner;

class Rock {
    char size; //grand ou pequena | pequena só pode ser usada uma vez
    int distance_left; //entrada
    int distance_right; //d - left
    boolean available; //define se pode ser usada ou n

    Rock() {
        this.available = true;
    }
}

class TestCase {
    int n; // número de pedras - max 100
    int d; // distância entre as margens - max 10^9
    Rock[] rocks; 
}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int cases = sc.nextInt();
        sc.nextLine();

        TestCase[] testCases = new TestCase[cases];
        //organização da entrada
        for(int i = 0; i < cases; i++) {
            testCases[i] = new TestCase();
            testCases[i].n = sc.nextInt();
            testCases[i].d = sc.nextInt();
            sc.nextLine();
            //strings do tipo "tamanho - distância até a margem esquerda"
            String [] rocks = sc.nextLine().split(" ");
            testCases[i].rocks = new Rock[rocks.length + 2];

            //margem esquerda
            testCases[i].rocks[0] = new Rock();
            testCases[i].rocks[0].size = 'B';
            testCases[i].rocks[0].distance_right = testCases[i].d;
            testCases[i].rocks[0].distance_left = 0;

            for (int j = 0; j < rocks.length; j++) {
                testCases[i].rocks[j + 1] = new Rock();

                String[] aux = rocks[j].split("-");
                
                testCases[i].rocks[j + 1].size = aux[0].charAt(0);
                testCases[i].rocks[j + 1].distance_left = Integer.parseInt(aux[1]);
                testCases[i].rocks[j + 1].distance_right = testCases[i].d - testCases[i].rocks[j + 1].distance_left;
            
            }

            //margem direita
            int index = testCases[i].rocks.length - 1;
            testCases[i].rocks[index] = new Rock();
            testCases[i].rocks[index].size = 'B';
            testCases[i].rocks[index].distance_left = testCases[i].d;
            testCases[i].rocks[index].distance_right = 0;
        }

        for(int i = 0; i < cases; i++) {
            int d = testCases[i].d;
            int n = testCases[i].n + 2;
            Rock [] rocks = testCases[i].rocks;
            
            int max_jump = -1; //maior pulo do caso de teste
            int jump = 1000000000; //próximo pulo
            int current_choice = -1; //pedra escolhida nessa iteração
            int previous_choice = -1; //pedra escolhida na iteração anterior
            int sum_jumps = 0; //distância completa percorrida

            //ida - considera a distância da margem esquerda
            while(sum_jumps < d) {
                //inicia na pedra seguinte
                for(int j = (previous_choice == -1 ? 0 : previous_choice + 1); j < n; j++) {
                    if(!rocks[j].available || rocks[j].distance_left == 0) {
                        continue;
                    }
                    //se uma pedra já foi escolhida antes o pulo é a distância entre as pedras
                    int aux_jump = (previous_choice == -1) ? 
                                     rocks[j].distance_left : 
                                     rocks[j].distance_left - rocks[previous_choice].distance_left;
                    if(aux_jump < jump) {
                        jump = aux_jump;
                        current_choice = j;
                    }
                }

                previous_choice = current_choice;

                //se houve um pulo testa se é o maior e soma ao total
                if(jump != 1000000000) {
                    if(jump > max_jump) {
                        max_jump = jump;
                    }
                    sum_jumps += jump;
                    //reinicia
                    jump = 1000000000;
                }
                //se a pedra escolhida é pequena ela se torna indisponível
                if(current_choice != -1 && (rocks[current_choice].size == 's' || rocks[current_choice].size == 'S')) {
                    rocks[current_choice].available = false;
                    //reinicia
                    current_choice = -1;
                }
            }

            //volta - considera a distância da margem direita
            while(sum_jumps < d * 2) {
                for(int j = (previous_choice == n - 1) ?  n - 1 : previous_choice - 1; j >= 0; j--) {
                    if(!rocks[j].available || rocks[j].distance_right == 0) {
                        continue;
                    }

                    int aux_jump = (previous_choice == -1) ? 
                                     rocks[j].distance_right : 
                                     rocks[j].distance_right - rocks[previous_choice].distance_right;
                    if(aux_jump < jump && j != previous_choice) {
                        jump = aux_jump;
                        current_choice = j;
                    }
                }

                previous_choice = current_choice;

                if(jump != 1000000000) {
                    if(jump > max_jump) {
                        max_jump = jump;
                    }
                    sum_jumps += jump;
                    jump = 1000000000;
                }

                if(current_choice != -1 && (rocks[current_choice].size == 's' || rocks[current_choice].size == 'S')) {
                    rocks[current_choice].available = false;
                    current_choice = -1;
                }
            }

            //imprime o maior pulo de cada caso de teste
            System.out.println("Case " + (i + 1) + ": " + max_jump);
        }

    }
}
