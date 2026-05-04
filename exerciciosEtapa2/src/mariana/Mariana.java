package mariana;

import java.util.Scanner;

public class Mariana {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] livros = sc.nextLine().split(",");
		sc.close();
		
		insertionSort(livros);
	}

	public static void insertionSort(String[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j >= 1; j--) {
				if (array[j].compareTo(array[j - 1]) < 0) {
					String aux = array[j];
					array[j] = array[j - 1];
					array[j - 1] = aux;
				} else {
					break;
				}
			}
			
			System.out.println(String.join(", ", array));
		}
	}
}
