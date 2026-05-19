package praticaParaMergeQuickSort;

import java.util.Scanner;

public class EstatisticaDeOrdem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		System.out.println(qntElementosMenores(array));
		particionamentoLomuto(array, 0, array.length - 1);
	}
	
	public static int qntElementosMenores(int[] v) {
		int ordem = 1;
		for (int i = 1; i < v.length; i++) {
			if (v[0] >= v[i]) {
				ordem++;
			}
		}
		
		return ordem;
	}
	
	public static void particionamentoLomuto(int[] v, int ini, int fim) {
		int posPivot = ini;
		for (int i = ini + 1; i <= fim; i++) {
			if (v[i] <= v[ini]) {
				swap(v, i, ++posPivot);
			}
		}
		
		swap(v, posPivot, ini);
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
