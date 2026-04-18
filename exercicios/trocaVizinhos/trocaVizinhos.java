package trocaVizinhos;

import java.util.Arrays;
import java.util.Scanner;

class trocaVizinhos{
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	String[] linha = sc.nextLine().split(" ");
    	sc.close();
    	
    	int[] numeros = transformaInt(linha);
    	trocaVizinho(numeros);
    	System.out.println(Arrays.toString(numeros));
    }
    
    public static void trocaVizinho(int[] numeros) {
    	for (int i = 0; i < numeros.length - 1; i += 2) {
    		int temp = numeros[i];
    		numeros[i] = numeros[i + 1];
    		numeros[i + 1] = temp;
    	}
    }
    
    public static int[] transformaInt(String[] linha) {
    	int[] numeros = new int[linha.length];
    	for (int i = 0; i < numeros.length; i++) {
    		numeros[i] = Integer.parseInt(linha[i]);
    	}
    	
    	return numeros;
    }
}
