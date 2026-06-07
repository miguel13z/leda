package parenteses;

import java.util.Scanner;

public class Parenteses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String linha[] = sc.nextLine().split("");
		sc.close();
		System.out.println(parenteses(linha));
	}

	private static char parenteses(String[] linha) {
		Pilha pilha = new Pilha(linha.length);
		for (String c : linha) {
			if (c.equals("(")) {
				pilha.push(c);
			}
			else {
				boolean ehPossivel = pilha.pop();
				if (!ehPossivel) return 'N';
			}
		}
		
		if (pilha.isEmpty()) {
			return 'S';
		} else {
			return 'N';
		}
		
	}

}

class Pilha {
	private String[] pilha;
	private int topo;
	
	public Pilha(int tamanho) {
		pilha = new String[tamanho];
		topo = -1;
	}
	
	public void push(String elemento) {
		pilha[++topo] = elemento;
	}
	
	public boolean pop() {
		if (isEmpty()) return false;
		topo--;
		return true;
	}
	
	public boolean isEmpty() {
		return topo == -1;
	}
}
