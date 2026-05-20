package praticaParaCountingRadixSort;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSortTresDigitos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int d = sc.nextInt();
		sc.close();
		int[] array = converteInt(linha);
		radixSort(array, d);
	}
	
	public static void radixSort(int[] v, int qntDigitos) {
		for (int i = 3; i <= qntDigitos; i += 3) {
			int exp = (int) Math.pow(10, i - 3);
			countingSort(v, exp);
			System.out.println(Arrays.toString(v));
		}
		
	}

	public static void countingSort(int[] v, int exp) {
		int[] c = new int[1000];
		for (int i = 0; i < v.length; i++) {
			int digito = (v[i] / exp) % 1000;
			c[digito] += 1;
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		int[] b = new int[v.length];
		for (int i = v.length - 1; i >= 0; i--) {
			int digito = (v[i] / exp) % 1000;
			b[c[digito] - 1] = v[i];
			c[digito] -= 1;
		}
		
		for (int i = 0; i < v.length; i ++) {
			v[i] = b[i];
		}
		
	}

	public static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}
	
}
