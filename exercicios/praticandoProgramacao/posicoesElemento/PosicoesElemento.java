package posicoesElemento;

import java.util.Scanner;

// A função posicoesElemento é O(n).
public class PosicoesElemento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		
		int[] seq = converteInt(linha);
		System.out.println(posicoesElemento(num, seq));
	}

	public static String posicoesElemento(int num, int[] seq) {
		String posicoes = "";
		for (int i = 0; i < seq.length; i++) {
			if (num == seq[i]) {
				posicoes += i + " ";
			}
		}
		
		if (posicoes.equals("")) {
			return "-1";
		}
		return posicoes.trim();
	}

	private static int[] converteInt(String[] linha) {
		int[] seq = new int[linha.length];
		for(int i = 0; i < seq.length; i++) {
			seq[i] = Integer.parseInt(linha[i]);
		}
		
		return seq;
	}

}
