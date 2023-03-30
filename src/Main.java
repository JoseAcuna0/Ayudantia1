import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

public class Main {
    public static void main(String[] args) {
        int saldo = 1000;
        int[] ruedas = new int[3];

        while(saldo != 0){
            StdOut.println("Su saldo actual es de " + saldo +". ¿Cuanto desea apostar?: ");
            int apuesta = StdIn.readInt();

            if (0< apuesta && apuesta <= apuesta){
                saldo = saldo - apuesta;

                ruedas[0] = (int) (Math.random() * 10);
                ruedas[1] = (int) (Math.random() * 10);
                ruedas[2] = (int) (Math.random() * 10);

                imprimirruedas(ruedas);

                int premio = obtenerpremio(ruedas, apuesta);

                if (0 < premio){
                    StdOut.println("Usted Obtiene $" + premio);
                    saldo = saldo + premio;
                }

            }
            else{
                break;
            }
        }
    }

    public static void imprimirruedas(int[] ruedas){
        StdOut.println("+---+---+---+");
        for (int i = 0; i < 3; i++){
            if (ruedas[i] == 0){
                StdOut.print("| * ");
            }else{
                StdOut.print("| "+ ruedas[i] + " ");
            }
        }
        StdOut.println("|");
        StdOut.println("+---+---+---+");
    }

    public static int obtenerpremio(int[] ruedas, int apuesta){
        if (ruedas[0] == ruedas[1] && ruedas[1] == ruedas[2] && ruedas[0] != 0){
            return ruedas[0] * apuesta;
        }
        int contador = 0;
        for (int i = 0; i < 3; i++){
            if(ruedas[i] == 0){
                contador = contador + 1;
            }
        }
        switch (contador){
            case 1:
                return 50;
            case 2:
                return 300;
            case 3:
                return 500;
            default:
                return 0;
        }
        }
}