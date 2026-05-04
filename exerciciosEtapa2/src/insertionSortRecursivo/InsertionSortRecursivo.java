package insertionSortRecursivo;

import java.util.Arrays;
import java.util.Scanner;

// A função insertionSortRecursivo é O(n^2).
public class InsertionSortRecursivo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		
		insertionSortRecursivo(array, 1);
	}

	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
	
	public static void insertionSortRecursivo(int[] array, int comp) {
		if (comp >= array.length) {
			return;
		}
		
		for (int i = comp; i >= 1; i--) {
			if (array[i] < array[i - 1]) {
				int aux = array[i];
				array[i] = array[i - 1];
				array[i - 1] = aux;
			} else {
				break;
			}
		}
		
		System.out.println(Arrays.toString(array));
		insertionSortRecursivo(array, comp + 1);
		
	}

}
