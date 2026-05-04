package topN;

import java.util.Scanner;

// A função topN é O(x * n), em que x é o int top.
public class TopN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String linha[] = sc.nextLine().split(" ");
		int top = sc.nextInt();
		sc.close();
		
		int[] array = converteInt(linha);
		System.out.println(topN(array, top));
	}

	public static String topN(int[] array, int top) {
		for (int i = 0; i < top; i++) {
			for (int j = 0; j < array.length -1 - i; j++) {
				if (array[j] > array[j + 1]) {
					int aux = array[j];
					array[j] = array[j + 1];
					array[j + 1] = aux;
				}
			}
		}
		
		String out = "";
		for (int i = array.length - 1; i > array.length - 1 - top; i--) {
			out += array[i] + " ";
		}
		
		return out.trim();
	}

	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}
		
		return array;
	}

}
