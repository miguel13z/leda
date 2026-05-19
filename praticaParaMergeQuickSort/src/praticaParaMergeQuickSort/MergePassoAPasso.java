package praticaParaMergeQuickSort;

import java.util.Arrays;
import java.util.Scanner;

public class MergePassoAPasso {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		sort(array, 0, array.length - 1);
	}
	
	public static void sort(int[] v, int ini, int fim) {
		System.out.println(Arrays.toString(recortaArray(v, ini, fim)));
		
		if (ini >= fim) {
			return;
		}
		
		int meio = (ini + fim) / 2;
		
		sort(v, ini, meio);
		sort(v, meio + 1, fim);
		
		merge(v, ini, meio, fim);
	}
	
	public static void merge(int[] v, int ini, int meio, int fim) {
		int[] aux = new int[v.length];
		for (int c = ini; c <= fim; c++) {
			aux[c] = v[c];
		}
		
		int i = ini;
		int j = meio + 1;
		int k = ini;
		while (i <= meio && j <= fim) {
			if (aux[i] <= aux[j]) {
				v[k++] = aux[i++];
			} else {
				v[k++] = aux[j++];
			}
		}
		
		while (i <= meio) {
			v[k++] = aux[i++];
		}
		
		System.out.println(Arrays.toString(recortaArray(v, ini, fim)));
	}
	
	public static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
	
	public static int[] recortaArray(int[] v, int ini, int fim) {
		int[] recorte = new int[fim + 1 - ini];
		int k = 0;
		for (int i = ini; i <= fim; i++) {
			recorte[k++] = v[i];
		}
		
		return recorte;
	}
}
