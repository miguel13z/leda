package invertePilha;

import java.util.Scanner;

public class InvertePilha {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = Integer.parseInt(sc.nextLine());
		String[] linha = sc.nextLine().split(" ");
		int[] entrada = converteInt(linha);
		sc.close();
		
		invertePilha(tamanho, entrada);
	}
	
	
	private static void invertePilha(int tamanho, int[] entrada) {
		Pilha pilha = new Pilha(tamanho);
		
		for (int num : entrada) {
			pilha.push(num);
		}
		
		Pilha pilhaAux = new Pilha(tamanho);
		while (!pilha.isEmpty()) {
			pilhaAux.push(pilha.pop());
		}
		
		while(!pilhaAux.isEmpty()) {
			int elemento = pilhaAux.pop();
			System.out.println(elemento);
		}
	}


	private static int[] converteInt(String[] linha) {
		int[] entrada = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			entrada[i] = Integer.parseInt(linha[i]);
		}
		
		
		return entrada;
	}
}

class Pilha {
	private int[] pilha;
	private int topo;
	
	public Pilha(int tamanho) {
		pilha = new int[tamanho];
		topo = -1;
	}
	
	public void push(int valor) {
		pilha[++topo] = valor;
	}
	
	public boolean isEmpty() {
		return topo == -1;
	}
	
	public int pop() {
		int elemento = pilha[topo--];
		return elemento;
	}
}
