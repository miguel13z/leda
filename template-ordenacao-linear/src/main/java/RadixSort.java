public class RadixSort {

	// Você pode assumir que todos os valores possuem a mesma quantidade de dígitos
	// Caso precise do counting sort, use o que você já implementou na outra classe.
	public int[] radixSort(int[] v) {
		int maiorNum = procuraMaiorNum(v);
		int qntDigitos = (maiorNum + "").length();
		
		for (int i = 1; i <= qntDigitos; i++) {
			int exp = (int) Math.pow(10, i - 1);
			countingSort(v, exp);
		}
		
		return v;
	}
	
	public void countingSort(int[] v, int exp) {
		int[] c = new int[10];
		for (int i = 0; i < v.length; i++) {
    		int digito = (v[i] / exp) % 10;
    		c[digito] += 1;
    	}
		
		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}
		
		int[] b = new int[v.length];
		for (int i = v.length - 1; i >= 0; i--) {
			int digito = (v[i] / exp) % 10;
			b[c[digito] - 1] = v[i];
			c[digito] -= 1;
		}
		
		for (int i = 0; i < v.length; i++) {
			v[i] = b[i];
		}
	}

	public int procuraMaiorNum(int[] v) {
		if (v.length == 0) return 0;
		
		int maiorNum = v[0];
		for (int num : v) {
			if (num > maiorNum) {
				maiorNum = num;
			}
		}
		
		return maiorNum;
	}

}