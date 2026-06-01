import java.util.Arrays;

public class MeusTestes {

	public static void main(String[] args) {
		ArrayList lista = new ArrayList(5);
		lista.addFirst(1);
		lista.addFirst(3);
		lista.addFirst(6);
		lista.add(1, 10);
		lista.add(2, 20); // [6, 10, 20, 3, 1]
		System.out.println(lista.removeFirst());
		
		
	
		
		System.out.println(lista.toString());

	}

}
