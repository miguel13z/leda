package moveN;

import java.util.Arrays;
import java.util.Scanner;

// A função moveN é O(n^2).
public class MoveN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		
		int[] array = converteInt(linha);
		moveN(array);
	}
	
	public static void moveN(int[] array) {
		int pos = -1;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				pos = i + 1;
				break;
			}
		}
		
		for (int i = 0; i < array.length - pos; i++) {
			for (int j = pos + i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int aux = array[j];
					array[j] = array[j - 1];
					array[j - 1] = aux;
					
					System.out.println(Arrays.toString(array));
				} else {
					break;
				}
			}
		}
	}
	
	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}
		
		return array;
	}

}
