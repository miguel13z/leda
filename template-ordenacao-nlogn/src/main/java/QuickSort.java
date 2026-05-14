import java.util.Arrays;

public class QuickSort implements SortingStrategy {

  
    /*
       A mediana de uma sequência de tamanho ímpar é o valor que divide uma sequência ao meio, isto é, 
       metado dos valores são menores que ela, enquanto metade são maiores. Implemente o método abaixo
       que recebe uma sequência de tamanho ímpar e retorna a mediana dessa sequência.
    */
    public int mediana(int[] v) {
    	int posMediana = v.length / 2;
    	Arrays.sort(v);
        return v[posMediana];
    }

    /**
    * Implemente a versão do quick sort usando o particionamento Hoare, que está descrito
    * neste material: https://joaoarthurbm.github.io/eda/posts/particionamento-hoare/
    */
    public void sort(int[] v, int ini, int fim) {
        if (ini >= fim) {
        	return;
        }
        
        int indexPivo = particiona(v, ini, fim);
        
        sort(v, ini, indexPivo - 1);
        sort(v, indexPivo + 1, fim);
    }
    
    public int particiona(int[] v, int ini, int fim) {
    	int i = ini;
    	int j = ini + 1;
    	while (j <= fim) {
    		if (v[ini] >= v[j]) {
    			i++;
    			swap(v, i, j);
    		}
    		j++;
    	}
    	
    	swap(v, ini, i);
    	
    	return i;
    }


    public void swap(int[] v, int i, int j) {
		int aux = v[i];
		v[i] = v[j];
		v[j] = aux;
	}

	/**
    * Nós discutimos em sala de aula que uma tentativa para melhorar a escolha do pivot é
    * decidir usar o valores mediano (não média, cuidado) entre o primeiro elemento do array,
    * o elemento central e o último.

    * Implemente o método abaixo que retorna o valor que seria escolhido como pivot seguindo
    * a abordagem acima.
    * 
    * Interprete os testes para saber qual valor usar como elemento central para calcular a mediana de três.
    */
    public int medianaDeTres(int[] v) {
    	int meio = (v.length + 1) / 2 - 1;
    	
    	int[] sorted = new int[] {v[0], v[meio], v[v.length - 1]};
    	Arrays.sort(sorted);
    	
    	if (v[0] == sorted[1]) {
    		return v[0];
    	}
    	if (v[meio] == sorted[1]) {
    		return v[meio];
    	}
    	
        return v[v.length - 1];
    }

}
