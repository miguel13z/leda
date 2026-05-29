
public class MeuTeste {

	public static void main(String[] args) {
		Fila fila = new Fila(5);
        fila.addLast(10);
        
        fila.removeFirst();

        fila.addLast(10);
        fila.addLast(20);
        fila.addLast(30);
        fila.addLast(40);
        fila.addLast(50);

        
        System.out.println(fila.getFirst());  //== 10;
	}

}
