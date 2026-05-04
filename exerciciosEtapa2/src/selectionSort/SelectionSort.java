package selectionSort;

import java.util.Arrays;
import java.util.Scanner;

// A função selectionSort é O(n^2);
public class SelectionSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		
		selectionSort(array);
	}
	
	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
	
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int menor = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[menor]) {
					menor = j;
				}
			}
			
			if (menor != i) {
				int aux = array[i];
				array[i] = array[menor];
				array[menor] = aux;
				
				System.out.println(Arrays.toString(array));
			}
		}
		
	}

}
