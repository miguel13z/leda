package selectionSortRecursivo;

import java.util.Arrays;
import java.util.Scanner;

// A função selectionSortRecursivo é O(n^2);
public class SelectionSortRecursivo {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		
		selectionSortRecursivo(array, 0);
	}
	
	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
	
	public static void selectionSortRecursivo(int[] array, int pos) {
		if (pos >= array.length - 1) {
			return;
		}
		
		int menor = pos;
		for (int i = pos + 1; i < array.length; i++) {
			if (array[i] < array[menor]) {
				menor = i;
			}
		}
		
		if (menor != pos) {
			int aux = array[pos];
			array[pos] = array[menor];
			array[menor] = aux;
		}
		
		System.out.println(Arrays.toString(array));
		selectionSortRecursivo(array, pos + 1);
	}

}
