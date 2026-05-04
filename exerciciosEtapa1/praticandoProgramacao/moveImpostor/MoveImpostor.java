package moveImpostor;

import java.util.Arrays;
import java.util.Scanner;

// A função moveImpostor é O(n).
public class MoveImpostor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		sc.close();
		
		int[] array = converteInt(linha);
		System.out.println(Arrays.toString(moveImpostor(array)));
	}

	public static int[] moveImpostor(int[] array) {
		int pos = -1;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				pos = i + 1;
				break;
			}
		}
		
		for (int i = pos; i >= 1; i--) {
			if (array[i] < array[i - 1]) {
				int aux = array[i];
				array[i] = array[i -1];
				array[i - 1] = aux;
			} else {
				break;
			}
		}
		
		return array;
	}

	private static int[] converteInt(String[] linha) {
		int[] array = new int[linha.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(linha[i]);
		}
		
		return array;
	}

}
