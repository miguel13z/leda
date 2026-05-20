package praticaParaCountingRadixSort;

import java.util.Arrays;
import java.util.Scanner;

public class RadixSortNegativos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linha);
		radixSort(array);
	}
	
	public static void radixSort(int[] v) {
		int menorNum = procuraMenorNum(v);
		int deslocamento = 0;
		if (menorNum < 0) {
			deslocamento = Math.abs(menorNum);
			deslocaNums(v, deslocamento);
		}
		
		int maiorNum = procuraMaiorNum(v);
		int qntDigitos = (maiorNum + "").length();
		for (int i = 1; i <= qntDigitos; i++) {
			int exp = (int) Math.pow(10, i - 1);
			countingSort(v, exp);
		}
		
		if (menorNum < 0) {
			deslocaNums(v, -deslocamento);
		}
		
		System.out.println(Arrays.toString(v));
	}

	public static void countingSort(int[] v, int exp) {
		int[] c = new int[10];
		for (int i = 0; i < v.length; i++) {
			int digito = (v[i] / exp) % 10;
			c[digito] += 1;
		}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		int[] b = new int[v.length];
		for (int i = v.length - 1; i >= 0; i--) {
			int digito = (v[i] / exp) % 10;
			b[c[digito] - 1] = v[i];
			c[digito] -= 1;
		}
		
		for (int i = 0; i < v.length; i++) {
			v[i] = b[i];
		}
	}

	public static void deslocaNums(int[] v, int deslocamento) {
		for (int i = 0; i < v.length; i++) {
			v[i] = v[i] + deslocamento;
		}
		
	}

	public static int procuraMaiorNum(int[] v) {
		if (v.length == 0) return 0;
		
		int maiorNum = v[0];
		for (int num : v) {
			if (num > maiorNum) {
				maiorNum = num;
			}
		}
		
		return maiorNum;
	}
	
	public static int procuraMenorNum(int[] v) {
		if (v.length == 0) return 0;
		
		int menorNum = v[0];
		for (int num : v) {
			if (num < menorNum) {
				menorNum = num;
			}
		}
		
		return menorNum;
	}

	public static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}

}
