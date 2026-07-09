package buildHeap;

import java.util.*;

public class BuildHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		sc.close();
		int[] v = converteEntrada(entrada);
		
		System.out.println(buildHeap(v));
	}

	private static String buildHeap(int[] v) {
		Heap tree = new Heap(v);
		return tree.toString();
	}

	private static int[] converteEntrada(String[] entrada) {
		if (entrada[0].isEmpty()) return new int[0];
		
		int[] v = new int[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			v[i] = Integer.parseInt(entrada[i]);
		}
		
		return v;
	}

}

class Heap {
	private int[] heap;
	
	public Heap() {
		this.heap = new int[0];
	}
	
	public Heap(int[] array) {
		this.heap = array;
		buildHeap(this.heap);
	}
	
	public void buildHeap(int[] v) {
		int iPai = getIndicePai(v.length - 1);
		for (int i = iPai; i >= 0; i--) {
			heapify(i);
		}
	}
	
	@Override
	public String toString() {
		return Arrays.toString(heap);
	}
	
	public void heapify(int i) {
		int maior = i;
		
	   	int left = getIndiceFilhoEsq(i);
		int right = getIndiceFilhoDir(i);
		
		if (isIndiceValido(left) && heap[left] > heap[maior]) {
			maior = left;
		}
		
		if (isIndiceValido(right) && heap[right] > heap[maior]) {
			maior = right;
		}
		
		if (maior != i) {
			swap(i, maior);
			heapify(maior);
		}
	}
	
	public void swap(int indice1, int indice2) {
		int aux = heap[indice1];
		heap[indice1] = heap[indice2];
		heap[indice2] = aux;
	}
	
	public int getIndicePai(int i) {
		return (i - 1) / 2;
	}
	
	private int getIndiceFilhoEsq(int i) {
		return 2 * i + 1;
	}
	
	private int getIndiceFilhoDir(int i) {
		return 2 * i + 2;
	}
	
	private boolean isIndiceValido(int i) {
		return i >= 0 && i < heap.length;
	}
}
