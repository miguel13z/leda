package probingLinear;

public class MeusTestes {

	public static void main(String[] args) {
		HashMap tabela = new HashMap(4);
		tabela.put(2, "miguel");
		tabela.put(6, "pedro");
		tabela.put(10, "josefa");
		tabela.remove(6);
		tabela.put(10, "glauber");
		tabela.put(14, "maria");
		
		
		System.out.println(tabela.toString());
	}

}
