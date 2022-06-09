import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        int a = 5;
        char b = 65;
        int c = (a>50) ? 10 : 0;                                //Operador ternario
        for (int i = 0; i < 30; i++) {                          //Uso del char como numero
            System.out.println((char) (b++));
        }

//---------------------------------------------------------------------------------------------------


        int arr[][] = {{3,4,5,6},{2,3,4,},{3},{4,5,6,7,2}};     //Repaso arreglos, se pueden llenar de inmediato usando las llaves despues del igual
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("["+arr[i][j]+"]");            //USAR PRINT NO PRINTLN
            }
            System.out.println();
        }
//---------------------------------------------------------------------------------------------------

        ArrayList<Integer> arreglo = new ArrayList<Integer>();  //Repaso ArrayList

        String numeroString = "1234";

        int numeroEntero = Integer.parseInt(numeroString);      //Uso de parse

        Scanner teclado = new Scanner(System.in);
        int num = teclado.nextInt();
//---------------------------------------------------------------------------------------------------

        Animal a0 = new Animal();
    }
}
