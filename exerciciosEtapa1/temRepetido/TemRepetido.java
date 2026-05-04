package temRepetido;

import java.util.Scanner;

public class TemRepetido {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		
		int[] v = converteInt(linha);
		System.out.println(temRepetido(v));
	}

	private static int[] converteInt(String[] linha) {
		int[] v = new int[linha.length];
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(linha[i]);
		}
		
		return v;
	}
	
	public static boolean temRepetido(int[] v) {
		for (int i = 0; i < v.length; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] == v[j]) {
					return true;
				}
			}
		}
		
		return false;
	}
}
