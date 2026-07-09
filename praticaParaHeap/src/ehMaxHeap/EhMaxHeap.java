package ehMaxHeap;

import java.util.*;

public class EhMaxHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		sc.close();
		int[] v = converteEntrada(entrada);
		
		System.out.println(ehMaxHeap(v));
	}

	private static boolean ehMaxHeap(int[] v) {
		if (v.length == 0) return true;
		return paiEhMaior(0, v);
	}
	
	private static boolean paiEhMaior(int i, int[] v) {
		if (!existeIndice(2 * i + 1, v) && !existeIndice(2 * i + 2, v)) {
			return true;
		}
		
		if (existeIndice(2 * i + 1, v)) {
			if (v[i] < filhoEsq(i, v)) return false;
		}
		
		if (existeIndice(2 * i + 2, v)) {
			if (v[i] < filhoDir(i, v)) return false;
		}
		
		return paiEhMaior(2 * i + 1, v) && paiEhMaior(2 * i + 2, v);
	}

	private static int filhoEsq(int i, int[] v) {
		return v[2 * i + 1];
	}
	
	private static int filhoDir(int i, int[] v) {
		return v[2 * i + 2];
	}
	
	private static boolean existeIndice(int i, int[] v) {
		return i >= 0 && i < v.length;
	}

	private static int[] converteEntrada(String[] entrada) {
		if (entrada[0].isEmpty()) return new int[0];
		
		int[] v = new int[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			v[i] = Integer.parseInt(entrada[i]);
		}
		
		return v;
	}

}
