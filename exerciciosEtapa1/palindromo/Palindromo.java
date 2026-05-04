package palindromo;
import java.util.Scanner;

class Palindromo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] palavra = sc.nextLine().toCharArray();
		sc.close();
		
		System.out.println(ehPalindromo(palavra));
	}
	
	public static boolean ehPalindromo(char[] palavra) {
		int i = 0;
		int j = palavra.length - 1;
		while (i < palavra.length / 2) {
			if (palavra[i] != palavra[j]) {
				return false;
			}
			
			i++;
			j--;
		}
		
		return true;
	}

}
