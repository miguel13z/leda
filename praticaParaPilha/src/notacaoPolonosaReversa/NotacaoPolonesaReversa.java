package notacaoPolonosaReversa;

import java.util.Scanner;

public class NotacaoPolonesaReversa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		
		System.out.println(notacaoPolonesaReversa(linha));
	}

	private static double notacaoPolonesaReversa(String[] linha) {
		Pilha pilha = new Pilha(linha.length);
		for (String c : linha) {
			if (ehNumero(c)) {
				pilha.push(Integer.parseInt(c));
			} else {
				double elemento2 = pilha.pop();
				double elemento1 = pilha.pop();
				
				if (c.equals("+")) {
					pilha.push(elemento1 + elemento2);
				} else if (c.equals("*")) {
					pilha.push(elemento1 * elemento2);
				} else if (c.equals("-")) {
					pilha.push(elemento1 - elemento2);
				} else if (c.equals("/")) {
					pilha.push(elemento1 / elemento2);
				}
			}
		}
		
		
		return pilha.pop();
	}
	
	private static boolean ehNumero(String num) {
		try {
			Integer.parseInt(num);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}

class Pilha {
	private double[] pilha;
	private int topo;
	
	public Pilha(int tamanho) {
		this.pilha = new double[tamanho];
		this.topo = -1;
	}
	
	public void push(double elemento) {
		pilha[++topo] = elemento;
	}
	
	public double pop() {
		double elemento = pilha[topo];
		topo--;
		return elemento;
	}
}
