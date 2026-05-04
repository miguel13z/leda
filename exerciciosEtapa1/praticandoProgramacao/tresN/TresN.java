package tresN;

import java.util.*;

// A função comparaTresN é O(n * x), em que x representa o custo da função tamTresN.
public class TresN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = sc.nextInt();
		sc.close();
		
		int menor = Math.min(i, j);
		int maior = Math.max(i, j);
		System.out.println(comparaTresN(menor, maior));
	}
	
	public static int comparaTresN(int comeco, int fim) {
		int tamMaiorSeq = -1;
		for (int i = comeco; i <= fim; i++) {
			int comparacao = tamTresN(i);
			if (comparacao > tamMaiorSeq) {
				tamMaiorSeq = comparacao;
			}
		}
		
		
		return tamMaiorSeq;
	}
	
	public static int tamTresN(int n) {
		int tam = 1;
		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
				tam++;
			} else {
				n = n * 3 + 1;
				tam++;
			}
		}
		
		return tam;
	}

}
