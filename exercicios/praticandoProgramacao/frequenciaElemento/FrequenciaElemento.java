package frequenciaElemento;

import java.util.Scanner;

// A função frequenciaElemento é O(n).
public class FrequenciaElemento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		String[] linha = sc.nextLine().split(" ");
		sc.close();

		int[] seq = converteInt(linha);
		System.out.println(frequenciaElemento(num, seq));
	}

	public static int frequenciaElemento(int num, int[] seq) {
		int total = 0;
		for (int elemento : seq) {
			if (elemento == num) {
				total++;
			}
		}

		return total;
	}

	private static int[] converteInt(String[] linha) {
		int[] seq = new int[linha.length];
		for (int i = 0; i < seq.length; i++) {
			seq[i] = Integer.parseInt(linha[i]);
		}
		
		return seq;
	}

}
