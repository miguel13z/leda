package buildHeap;

import java.util.*;

public class BuildHeap {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int[] v = converteEntrada(entrada);
		
		System.out.println(buildHeap(v));
	}

	private static char[] buildHeap(int[] v) {
		// TODO Auto-generated method stub
		return null;
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
		
	}
	
	public void buildHeap() {
		
	}
	
	public void heapify(int i) {
		int iFilhoEsq = getIndiceFilhoEsq(i);
		int iFilhoDir = getIndiceFilhoDir(i);
		if (isIndiceValido(iFilhoEsq) && isIndiceValido(iFilhoDir)) {
			int maior = Math.max(heap[i], Math.max(heap[iFilhoEsq], heap[iFilhoDir]));
			
			if (maior == heap[iFilhoDir]) {
				swap(i, iFilhoDir);
				heapify(iFilhoDir);
			}
			if (maior == heap[iFilhoEsq]) {
				swap(i, iFilhoEsq);
				heapify(iFilhoEsq);
			}
		} else if (isIndiceValido(iFilhoEsq)) {
			int maior = Math.max(heap[i], heap[iFilhoEsq]);
			
			if (maior == heap[iFilhoEsq]) {
				swap(i, iFilhoEsq);
				heapify(iFilhoEsq);
			}
		} else if (isIndiceValido(iFilhoDir)) {
			int maior = Math.max(heap[i], heap[iFilhoEsq]);
			
			if (maior == heap[iFilhoDir]) {
				swap(i, iFilhoDir);
				heapify(iFilhoDir);
			}
		}
	}
	
	public void swap(int indice1, int indice2) {
		int aux = heap[indice1];
		heap[indice1] = heap[indice2];
		heap[indice2] = aux;
	}
	
	public int getIndicePai(int i) {
		
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
