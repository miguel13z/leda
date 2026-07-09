package maxToMin;

import java.util.*;

public class MaxToMinHeap { // Nome padrão para bater com os scripts

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] entrada = sc.nextLine().split(" ");
        sc.close();
        
        if (entrada[0].isEmpty()) return;
        
        int[] v = new int[entrada.length];
        for (int i = 0; i < entrada.length; i++) {
            v[i] = Integer.parseInt(entrada[i]);
        }
        
        Heap heap = new Heap(v);
        
        heap.toMinHeap();
        
        System.out.println(heap.toString());
    }
}

class Heap {
    private int[] heap;
    
    public Heap(int[] array) {
        this.heap = array;
        buildMinHeap(); 
    }
    
    public void toMinHeap() {
        buildMinHeap();
    }

    private void buildMinHeap() {
        int iPai = parent(heap.length - 1);
        for (int i = iPai; i >= 0; i--) {
            minHeapify(i);
        }
    }
    
    private void minHeapify(int i) {
        int menor = i;
        
        int left = left(i);
        int right = right(i);
        
        if (isValid(left) && heap[left] < heap[menor]) {
            menor = left;
        }
        
        if (isValid(right) && heap[right] < heap[menor]) {
            menor = right;
        }
        
        if (menor != i) {
            swap(i, menor);
            minHeapify(menor);
        }
    }

    private void swap(int indice1, int indice2) {
        int aux = heap[indice1];
        heap[indice1] = heap[indice2];
        heap[indice2] = aux;
    }
    
    private int parent(int i) {
        return (i - 1) / 2;
    }
    
    private int left(int i) {
        return 2 * i + 1;
    }
    
    private int right(int i) {
        return 2 * i + 2;
    }
    
    private boolean isValid(int i) {
        return i >= 0 && i < heap.length;
    }
    
    @Override
    public String toString() {
        return Arrays.toString(heap);
    }
}