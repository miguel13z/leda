package downN;

import java.util.Scanner;

// A função downN é O(x * n), em que x é o int down.
public class DownN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String linha[] = sc.nextLine().split(" ");
		int down = sc.nextInt();
		sc.close();
		
		int[] array = converteInt(linha);
		System.out.println(downN(array, down));
	}
	
	public static String downN(int[] array, int down) {
		for (int i = 0; i < down; i++) {
			for (int j = array.length - 1; j >= 1 + i; j--) {
				if (array[j] < array[j - 1]) {
					int aux = array[j];
					array[j] = array[j - 1];
					array[j - 1] = aux;
				}
			}
		}
		
		String out = "";
		for (int i = 0; i < down; i++) {
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
