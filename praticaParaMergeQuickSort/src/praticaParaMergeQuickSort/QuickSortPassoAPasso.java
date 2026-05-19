package praticaParaMergeQuickSort;

import java.util.Scanner;

public class QuickSortPassoAPasso {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		sort(array, 0, array.length - 1);
	}
	
	public static void sort(int[] v, int ini, int fim) {
		if (ini >= fim) {
			return;
		}
		
		int indexPivot = particionamentoLomuto(v, ini, fim);
		
		sort(v, ini, indexPivot - 1);
		sort(v, indexPivot + 1, fim);
	}
	
	public static int particionamentoLomuto(int[] v, int ini, int fim) {
		int posPivot = ini;
		for (int i = ini + 1; i <= fim; i++) {
			if (v[i] <= v[ini]) {
				swap(v, i, ++posPivot);
			}
		}
		
		swap(v, posPivot, ini);
		
		imprimeArray(v);
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
	
	public static void imprimeArray(int[] v) {
		String arrayFormatado = "";
		for (int i = 0; i < v.length; i++) {
			if (i + 1 >= v.length) {
				arrayFormatado += v[i] + "";
			}
			else {
				arrayFormatado += v[i] + " ";
			}
		}
		
		System.out.println(arrayFormatado);
	}
}
