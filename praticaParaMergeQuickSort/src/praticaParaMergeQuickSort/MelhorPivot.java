package praticaParaMergeQuickSort;

import java.util.Scanner;

public class MelhorPivot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linhaArray = sc.nextLine().split(" ");
		String[] linhaIndice = sc.nextLine().split(" ");
		sc.close();
		int[] array = converteInt(linhaArray);
		int[] indices = converteInt(linhaIndice);
		System.out.println(melhorPivot(array,indices));
	}
	
	
	
	public static int melhorPivot(int[] array, int[] indices) {
		int melhorIndice = array.length / 2;
		int distanciaIndiceI = encontraDistancia(array, indices[0], melhorIndice);
		int distanciaIndiceJ = encontraDistancia(array, indices[1], melhorIndice);
		
		if (distanciaIndiceI <= distanciaIndiceJ) {
			return indices[0];
		}
		
		return indices[1];
	}



	public static int encontraDistancia(int[] array, int indice, int melhorIndice) {
		int indicePivot = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] <= array[indice]) {
				indicePivot += 1;
			}
		}
		
		return Math.abs(indicePivot - melhorIndice);
	}



	public static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}

		return array;
	}

}
