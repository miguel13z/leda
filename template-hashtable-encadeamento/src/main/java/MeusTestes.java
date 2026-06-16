import util.Aluno;

public class MeusTestes {

	public static void main(String[] args) {
		TabelaHashEncadeada tabela = new TabelaHashEncadeada(10);
		Aluno aluno = new Aluno(0, "miguel");
		Aluno aluno2 = new Aluno(10, "pedro");
		
		tabela.put(0, aluno);
		tabela.put(10, aluno2);
		System.out.println(tabela.get(0).toString());
		System.out.println(tabela.get(10).toString());
		System.out.println(tabela.containsKey(1));
		System.out.println(tabela.containsValue(aluno));
		System.out.println(tabela.containsValue(aluno2));
		System.out.println(tabela.containsValue(new Aluno(2, "joao")));
		System.out.println(tabela.containsValue(new Aluno(12, "miguel")));
		System.out.println(tabela.remove(0).toString());
	}
}
