package extractMax;

import java.util.*;

public class ExtractMax {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] entrada = sc.nextLine().split(" ");
		int qnt = Integer.parseInt(sc.nextLine());
		sc.close();
		int[] v = converteEntrada(entrada);
		
		System.out.println(extractMax(v, qnt));
	}

	private static int extractMax(int[] v, int qnt) {
		Heap tree = new Heap(v);
		for (int i = 1; i <= qnt - 1; i++) {
			tree.extractMax();
		}
		
		return tree.extractMax();
	}

	private static int[] converteEntrada(String[] entrada) {
		if (entrada[0].isBlank()) return new int[0];
		
		int[] v = new int[entrada.length];
		for (int i = 0; i < entrada.length; i++) {
			v[i] = Integer.parseInt(entrada[i]);
		}
		
		return v;
	}
}

class Heap {
	private int[] heap;
	private int size;
	
	public Heap(int[] v) {
		this.heap = v;
		this.size = v.length;
		maxHeap();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int extractMax() {
		if (isEmpty()) throw new RuntimeException("O Heap está vazio");
		
		int max = heap[0];
		swap(0, size - 1);
		size--;
		heapify(0);
		
		return max;
	}
	
	public String toString() {
		if (isEmpty()) return "[]";
		
		String out = "[";
		for (int i = 0; i < size; i++) {
			out += heap[i] + ", ";
		}
		
		return out.substring(0, out.length() - 2) + "]";
	}
	
	private void heapify(int i) {
		int maior = i;
		
		int left = getIndexLeft(i);
		int right = getIndexRight(i);
		
		if (isValid(left) && heap[left] > heap[maior]) {
			maior = left;
		}
		
		if (isValid(right) && heap[right] > heap[maior]) {
			maior = right;
		}
		
		if (maior != i) {
			swap(i, maior);
			heapify(maior);
		}
	}

	private void swap(int index1, int index2) {
		int aux = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = aux;
	}

	private void maxHeap() {
		int iParent = getIndexParent(size - 1);
		for (int i = iParent; i >= 0; i--) {
			heapify(i);
		}
	}
	
	private int getIndexLeft(int i) {
		return 2 * i + 1;
	}
	
	private int getIndexRight(int i) {
		return 2 * i + 2;
	}
	
	private int getIndexParent(int i) {
		return (i - 1) / 2;
	}
	
	private boolean isValid(int i) {
		return i >= 0 && i < size;
	}
}
