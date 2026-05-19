package praticaParaMergeQuickSort;

import java.util.Arrays;
import java.util.Scanner;

public class ParticionamentoLomutoUltimo {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		particionamentoLomutoUltimo(array, 0, array.length - 1);
		System.out.println(Arrays.toString(array));
	}
	
	public static int particionamentoLomutoUltimo(int[] v, int ini, int fim) {
		int posPivot = fim;
		for (int i = fim - 1; i >= ini; i--) {
			if (v[i] >= v[fim]) {
				swap(v, i, --posPivot);
				System.out.println(Arrays.toString(v));
			}
		}
		
		swap(v, fim, posPivot);
		System.out.println(Arrays.toString(v));
		
		return posPivot;
	}
	
	public static void swap(int[] v, int pos1, int pos2) {
		int aux = v[pos1];
		v[pos1] = v[pos2];
		v[pos2] = aux;
	}

	public static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
}

