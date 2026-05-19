package praticaParaCountingRadixSort;

import java.util.Arrays;
import java.util.Scanner;

public class CountingNegativoPassoAPasso {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int k = sc.nextInt();
		int menor = sc.nextInt();
		sc.close();
		int[] array = converteInt(linha);
		countingSort(array, k, menor);
	}
	
	public static void countingSort(int[] v, int k, int menor) {
		int[] c = new int[k + 1 - menor];
		for (int i = 0; i < v.length; i++) {
			c[v[i] - menor] += 1;
			System.out.println(Arrays.toString(c));
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(c));
		
		int[] b = new int[v.length];
		for (int i = v.length - 1; i >= 0; i--) {
			b[c[v[i] - menor] - 1] = v[i];
			c[v[i] - menor] -= 1;
		}
		
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(b));
	}
	
	public void imprimeArray(int[] array) {
		String arrayFormatado = "";
		for (int i = 0; i < array.length; i++) {
			if (i + 1 >= array.length) {
				arrayFormatado = array[i] + "";
			}
			else {
				arrayFormatado = array[i] + " ";
			}
		}
		
		System.out.println(arrayFormatado);
	}

	public static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
}
