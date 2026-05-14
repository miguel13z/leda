
public class MergeSort implements SortingStrategy {

    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma crescente
    * e retorna um novo array também ordenado em forma crescente.
    */
    public int[] mergeOrdenadosCrescente(int[] a, int[] b) {
    	int[] array = new int[a.length + b.length];
    	
    	int i = 0;
    	int j = 0;
    	int pos = 0;
    	while (i < a.length && j < b.length) {
    		if (a[i] < b[j]) {
    			array[pos++] = a[i++];
    		}
    		else {
    			array[pos++] = b[j++];
    		}
    	}
    	
    	while (i < a.length) {
    		array[pos++] = a[i++];
    	}
    	
    	while (j < b.length) {
    		array[pos++] = b[j++];
    	}
    	
        return array;
    }
    
    /**
    * Implemente o método abaixo, que recebe dois arrays ordenados em forma decrescente
    * e retorna um novo array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDecrescente(int[] a, int[] b) {
    	int[] array = new int[a.length + b.length];
    	
    	int i = 0;
    	int j = 0;
    	int pos = a.length + b.length - 1;
    	while (i < a.length && j < b.length) {
    		if (a[i] > b[j]) {
    			array[pos--] = a[i++];
    		}
    		else {
    			array[pos--] = b[j++];
    		}
    	}
    	
    	while (i < a.length) {
    		array[pos--] = a[i++];
    	}
    	
    	while (j < b.length) {
    		array[pos--] = b[j++];
    	}
    	
        return array;
    }
   
    /**
    * Implemente o método abaixo, que recebe dois arrays: a, ordenado em forma crescente e b, ordenado
    * em forma descrescente. Seu método deve retornar um array ordenado em forma crescente.
    */
    public int[] mergeOrdenadosDistintos(int[] a, int[] b) {
    	int[] array = new int[a.length + b.length];
    	
    	int i = 0;
    	int j = b.length - 1;
    	int pos = 0;
    	while (i < a.length && j >= 0) {
    		if (a[i] < b[j]) {
    			array[pos++] = a[i++];
    		}
    		else {
    			array[pos++] = b[j--];
    		}
    	}
    	
    	while (i < a.length) {
    		array[pos++] = a[i++];
    	}
    	
    	while (j >= 0) {
    		array[pos++] = b[j--];
    	}
    	
        return array;
    }
   
    /**
    * Implemente a versão clássica do merge sort que vimos em sala de aula. Você pode
    * criar métodos auxiliares se precisar.
    */
    public void sort(int[] v, int ini, int fim) {
    	if (ini >= fim) {
    		return;
    	}
    	
    	int meio = (ini + fim) / 2;
    	sort(v, ini, meio);
    	sort(v, meio + 1, fim);
    	
    	merge(v, ini, meio, fim);
    }

	public void merge(int[] v, int ini, int meio, int fim) {
		int[] aux = new int[v.length];
		for (int c = ini; c <= fim; c++) {
			aux[c] = v[c];
		}
		
		int i = ini;
		int j = meio + 1;
		int k = ini;
		while (i <= meio && j <= fim) {
			if (aux[i] <= aux[j]) {
				v[k++] = aux[i++];
			}
			else {
				v[k++] = aux[j++];
			}
		}
		
		while (i <= meio) {
			v[k++] = aux[i++];
		}
	}
}
