
public class MeusTestes {

	public static void main(String[] args) {
		FIFOCache fila = new FIFOCache(5);
		System.out.println(fila.toString());
		fila.addLast("a");
		fila.addLast("b");
		fila.addLast("c");
		fila.removeFirst();
		fila.removeFirst();
		fila.addLast("d");
		fila.addLast("e");
		fila.addLast("f");
		fila.addLast("g");
		System.out.println(fila.toString());
		fila.addLast("h");
		System.out.println(fila.toString());
		fila.addLast("i");
		System.out.println(fila.toString());
		fila.removeFirst();
		fila.removeFirst();
		fila.removeFirst();
		fila.removeFirst();
		fila.addLast("j");
		System.out.println(fila.toString());
		fila.removeFirst();
		System.out.println(fila.toString());
	}

}
