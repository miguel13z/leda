package praticaParaCountingRadixSort;

import java.util.Scanner;

public class CountingPassoAPasso {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int k = sc.nextInt();
		sc.close();
		int[] array = converteInt(linha);
		coutingSort(array, k);
	}
	
	public static void coutingSort(int[] v, int k) {
		int[] c = new int[k + 1];
		for (int i = 0; i < v.length; i++) {
			c[v[i]] += 1;
			imprimeArray(c);
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		System.out.print("Cumulativa do vetor de contagem - ");
		imprimeArray(c);
		
		int[] b = new int[v.length];
		for (int i = v.length - 1; i >= 0; i--) {
			b[c[v[i]] - 1] = v[i];
			c[v[i]] -= 1;
		}
		
		imprimeArray(c);
		
		imprimeArray(b);
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
	
	public static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
	
}
