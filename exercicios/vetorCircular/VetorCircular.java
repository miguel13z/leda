package vetorCircular;

import java.util.Scanner;

public class VetorCircular {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int qntElementos = sc.nextInt();
		sc.close();
		
		int[] array = converteInt(linha);
		System.out.println(vetorCircular(array, qntElementos).trim());
	}
	
	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}
		
		return array;
		
	}

	public static String vetorCircular(int[] array, int qntElementos) {
		String out = "";
		for (int i = 0; i < qntElementos; i++) {
			out += array[i % array.length] + " ";
		}
		
		
		return out;
	}
}
