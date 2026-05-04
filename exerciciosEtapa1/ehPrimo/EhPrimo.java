package ehPrimo;

import java.util.Scanner;

public class EhPrimo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numero = sc.nextInt();
		sc.close();
		
		System.out.println(ehPrimo(numero));
	}

	public static boolean ehPrimo(int numero) {
		if (numero <= 1) {
			return false;
		}
		
		for (int i = 2; i < numero; i++) {
			if (numero % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	

}
