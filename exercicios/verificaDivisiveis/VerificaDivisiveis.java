package verificaDivisiveis;

import java.util.Scanner;

public class VerificaDivisiveis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		
		int[] v = converteInt(linha);
		System.out.println(verificaDivisiveis(v));
	}

	private static int[] converteInt(String[] linha) {
		int[] v = new int[linha.length];
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(linha[i]);
		}
		
		return v;
	}
	
	public static boolean verificaDivisiveis(int[] v) {
		for(int i = 0; i < v.length - 1; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] != 0 && v[j] != 0 && (v[i] % v[j] == 0 || v[j] % v[i] == 0)) {
					return true;
				}
			}
		}
		
		return false;
	}

}
