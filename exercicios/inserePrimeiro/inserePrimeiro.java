package inserePrimeiro;
import java.util.Scanner;
import java.util.Arrays;

public class inserePrimeiro{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] linha = sc.nextLine().split(" ");
        sc.close();

        int[] numeros = transformaInt(linha);
        for (int i = 0; i < numeros.length - 1; i++){
            if (numeros[i] > numeros[i + 1]){
                int temp = numeros[i];
                numeros[i] = numeros[i + 1];
                numeros[i + 1] = temp;
            }
            else {
                break;
            }
        }

        System.out.println(Arrays.toString(numeros));
    }

    public static int[] transformaInt(String[] linha){
        int[] numeros = new int[linha.length];
        for (int i = 0; i < linha.length; i++){
            numeros[i] = Integer.parseInt(linha[i]);
        }

        return numeros;
    }
}
