package praticaParaMergeQuickSort;

import java.util.Arrays;
import java.util.Scanner;

public class MedianaTres {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		int[] v = converteInt(linha);
		lomutoPartition(v);
		System.out.println(Arrays.toString(v));
	}

	public static int lomutoPartition(int v[]) {
		swap(v, 0, medianaTres(v));
		
		int posPivot = 0;
		for (int i = 1; i < v.length; i++) {
			if (v[0] >= v[i]) {
				swap(v, ++posPivot, i);
			}
		}
		
		swap(v, 0, posPivot);
		
		return posPivot;
	}
	
	public static int medianaTres(int[] v) {
		int a = v[0];
		int b = v[(v.length - 1) / 2];
		int c = v[v.length - 1];
		
		if ((a >= b && a <= c) || (a >= c && a <= b)) {
			return 0;
		} else if ((b >= a && b <= c) || (b >= c && b <= a)) {
			return v.length / 2;
		}
		
		return v.length - 1;
	}

	public static int[] converteInt(String[] linha) {
		int[] v = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			v[i] = Integer.parseInt(linha[i]);
		}
		
		return v;
	}
	
	public static void swap(int[] v, int pos1, int pos2) {
		int aux = v[pos1];
		v[pos1] = v[pos2];
		v[pos2] = aux;
	}
	
}
