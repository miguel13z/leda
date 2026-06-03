package praticaParaPilha;

import java.util.Scanner;

public class InvertePilhaSemFila {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tamanho = Integer.parseInt(sc.nextLine());
		String[] linha = sc.nextLine().split(" ");
		int[] entrada = converteInt(linha);
		
		Pilha pilha = new Pilha(tamanho);
		for (int i = 0; i < entrada.length; i++) {
			pilha.push(entrada[i]);
		}
		
	}
	
	private static void invertePilha(Pilha pilha) {
		
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
	
	public boolean isEmpty() {
		return topo == -1;
	}
	
	public void push(int valor) {
		topo++;
		pilha[topo] = valor;
	}
	
	public int pop() {
		if (isEmpty()) throw new RuntimeException("A pilha já está vazia.");
		
		int elemento = pilha[topo];
		topo--;
		
		return elemento;
	}
	
}
