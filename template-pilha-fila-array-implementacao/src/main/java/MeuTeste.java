
public class MeuTeste {

	public static void main(String[] args) {
		Pilha pilha = new Pilha(10);
		pilha.push(1);
		pilha.push(10);
		pilha.push(20);
		pilha.push(3);
		pilha.push(0);
		
		System.out.println(pilha.indexOf(-20));
		System.out.println(pilha.size());
	}

}
