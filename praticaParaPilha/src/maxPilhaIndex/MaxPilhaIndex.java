package maxPilhaIndex;

import java.util.Scanner;

public class MaxPilhaIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int index = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] nums = converteInt(linha);
		
		System.out.println(maxPilhaIndex(nums, index));
	}

	private static int maxPilhaIndex(int[] nums, int index) {
		Pilha pilha = new Pilha(nums.length);
		for (int num : nums) {
			pilha.push(num);
		}
		
		Pilha pilhaAux = new Pilha(index + 1);
		int maiorElemento = pilha.pop();
	    pilhaAux.push(maiorElemento);
		for (int i = 1; i <= index; i++) {
			int elemento = pilha.pop();
			if (elemento > maiorElemento) {
				maiorElemento = elemento;
			}
			pilhaAux.push(elemento);
		}
		
		while(!pilhaAux.isEmpty()) {
			int elemento = pilhaAux.pop();
			pilha.push(elemento);
		}
		
		return maiorElemento;
	}

	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < linha.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}
		
		return array;
	}

}

class Pilha {
	private int[] pilha;
	private int topo;
	
	public Pilha(int tamanho) {
		this.pilha = new int[tamanho];
		this.topo = -1;
	}
	
	public void push(int elemento) {
		pilha[++topo] = elemento;
	}
	
	public int pop() {
		int elemento = pilha[topo];
		topo--;
		return elemento;
	}
	
	public boolean isEmpty() {
		return topo == -1;
	}
	
	public boolean isFull() {
		return topo == pilha.length - 1;
	}
	
}
