import java.util.ArrayList;

import util.Aluno;

/**
 * Esta classe representa a implementação de uma Tabela Hash que usa endereçamento fechado (encadeamento)
 * para resolver colisões.
 * 
 * A implementação abaixo apenas lida com objetos do tipo aluno. Essa foi uma decisão para fins didáticos. 
 * Naturalmente, por ser uma estrutura de propósito geral, uma tabela hash deve ser capaz de manipular objetos
 * de qualquer tipo.
 *
 * Esta é uma versão simplificada para fins didáticos. Não lidamos com resize e rehash aqui. Isso é assunto de um exercício específico.
 *  
 * @author João Arthur
 * @see <a href="http://joaoarthurbm.github.io/eda">http://joaoarthurbm.github.io/eda</a>
 * Computação @ UFCG
 */
public class TabelaHashEncadeada {

    private ArrayList<Aluno>[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;

    /**
     * Cria uma nova tabela com a capacidade default 20.
     */
    @SuppressWarnings("unchecked")
	public TabelaHashEncadeada() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }
    
    /**
     * Cria uma nova tabela com a capacidade passada como parâmetro.
     * @param capacidade O número de posições da tabela.
     */
    @SuppressWarnings("unchecked")
	public TabelaHashEncadeada(int capacidade) {
        this.tabela = new ArrayList[capacidade];
    }
    
    /**
     * Calcula o hash de uma determinada chave. A função de hash é simples
     * e usa o método da divisão.
     * @param chave A chave para a qual se deseja calcular o hash.
     * @return O hash calculado tendo como base a chave e o tamanho da tabela.
     */
    private int hash(Integer chave) {
        return chave % tabela.length;
    }
    
    /**
     * Adiciona o par chave, valor na tabela.
     * @param chave a matrícula do aluno a ser adicionado.
     * @param valor o objeto Aluno a ser adicionado na tabela.
     */
    public void put(Integer chave, Aluno valor) {
    	int hash = hash(chave);
    	if (tabela[hash] == null) {
    		ArrayList<Aluno> novaLista = new ArrayList<>();
    		novaLista.add(valor);
    		tabela[hash] = novaLista;
    		return;
    	}
    	
		ArrayList<Aluno> lista = tabela[hash];
		for (int i = 0; i < lista.size(); i++) {
			int matricula = lista.get(i).getMatricula();
			if (matricula == chave) {
				lista.set(i, valor);
				return;
			}
		}
		
		lista.add(valor);
    }

    /**
     * Recupera o aluno cuja chave é igual a passada como parâmetro.
     * @param chave a matrícula do aluno.
     * @return o aluno com a matrícula passada como parâmetro. null caso
     * nenhum aluno presente na tabela tenha a matrícula igual a passada como
     * parâmetro.
     */
    public Aluno get(Integer chave) {
    	int hash = hash(chave);
    	if (tabela[hash] == null) return null;
    	
    	ArrayList<Aluno> lista = tabela[hash];
    	for (int i = 0; i < lista.size(); i++) {
    		Aluno aluno = lista.get(i);
    		if (aluno.getMatricula() == chave) return aluno;
    	}
    	
        return null;
    }  

     public boolean containsKey(Integer chave) {
    	 int hash = hash(chave);
    	 if (tabela[hash] == null) return false;
    	 
    	 ArrayList<Aluno> lista = tabela[hash];
    	 for (int i = 0; i < lista.size(); i++) {
    		 int matricula = lista.get(i).getMatricula();
    		 if (matricula == chave) return true;
    	 }
    	
    	 return false;
    }

    public boolean containsValue(Aluno aluno) {
    	for (int i = 0; i < tabela.length; i++) {
    		ArrayList<Aluno> lista = tabela[i];
    		if (contemAluno(aluno, lista)) return true;
    	}
    	
        return false;
    }
    
    private boolean contemAluno(Aluno alunoAlvo, ArrayList<Aluno> lista) {
    	if (lista == null) return false;
    	
    	for (int i = 0; i < lista.size(); i++) {
    		Aluno aluno = lista.get(i);
    		if (aluno.equals(alunoAlvo)) return true;
    	}
    	
    	return false;
    }

    /**
     * Remove o aluno cuja matrícula é igual a chave passada como parâmetro.
     * @param chave A matrícula do aluno a ser removido.
     * @return O aluno a ser removido. null caso não haja aluno com a matrícula
     * passada como parâmetro. 
     */
    public Aluno remove(int chave) {
    	int hash = hash(chave);
    	if (tabela[hash] == null) return null;
    	
    	ArrayList<Aluno> lista = tabela[hash];
    	for (int i = 0; i < lista.size(); i++) {
    		Aluno aluno = lista.get(i);
    		if (aluno.getMatricula() == chave) {
    			lista.remove(i);
    			return aluno;
    		}
    	}
       
    	return null;
    }  

}
