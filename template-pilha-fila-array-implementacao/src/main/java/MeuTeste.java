
public class MeuTeste {

	public static void main(String[] args) {
		Pilha pilha = new Pilha(5);
        System.out.println(pilha.toString());
        pilha.push(10);
        System.out.println(pilha.toString());
        pilha.push(20);
        System.out.println(pilha.toString());
	}

}
