package encontraPrimeiroNegativo;

import java.util.Scanner;

// A função encontraPrimeiroNegativo é O(n).
public class EncontraPrimeiroNegativo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		
		int[] array = converteInt(linha);
		System.out.println(encontraPrimeiroNegativo(array, 0));
	}

	public static String encontraPrimeiroNegativo(int[] array, int indice) {
		if (indice == array.length) {
			return "-";
		}  
		
		if (array[indice] < 0) {
			return String.valueOf(array[indice]);
			
		}
		
		return encontraPrimeiroNegativo(array, indice + 1);
	}

	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for(int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}
		
		return array;
	}

}
