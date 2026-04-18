import java.util.Arrays;
import java.util.Scanner;

public class SomaDois {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] linha = sc.nextLine().split(" ");
		int target = sc.nextInt();
		sc.close();
		
		int[] v = converteInt(linha);
		System.out.println(Arrays.toString(twoSum(v, target)));
	}
	
	public static int[] converteInt(String[] linha) {
		int[] v = new int[linha.length];
		for (int i = 0; i < v.length; i++) {
			v[i] = Integer.parseInt(linha[i]);
		}
		
		return v;
	}
	
	public static int[] twoSum(int[] v, int target) {
		for (int i = 0; i < v.length; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] + v[j] == target) {
					int[] res = new int[2];
					res[0] = v[i];
					res[1] = v[j];
					return res;
				}
			}
		}
		
		return new int[0];
	}

}
