
public class MeuTeste {

	public static void main(String[] args) {
		Pilha pilha = new Pilha(5);
		System.out.println(pilha.indexOf(10));	 //== -1
        pilha.push(10);
        System.out.println(pilha.indexOf(10));  //== 0;
        pilha.push(20);
        System.out.println(pilha.indexOf(20));  ///== 1;
        
	}

}
