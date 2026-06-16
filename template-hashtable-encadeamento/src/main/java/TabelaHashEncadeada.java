import java.util.ArrayList;
import java.util.Iterator;

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
    public TabelaHashEncadeada() {
        this.tabela = new ArrayList[CAPACIDADE_DEFAULT];
    }
    
    /**
     * Cria uma nova tabela com a capacidade passada como parâmetro.
     * @param capacidade O número de posições da tabela.
     */
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
        //TODO implementar
        return 0;
    }
    
    /**
     * Adiciona o par chave, valor na tabela.
     * @param chave a matrícula do aluno a ser adicionado.
     * @param valor o objeto Aluno a ser adicionado na tabela.
     */
    public void put(Integer chave, Aluno valor) {
        // TODO implementar
    }

    /**
     * Recupera o aluno cuja chave é igual a passada como parâmetro.
     * @param chave a matrícula do aluno.
     * @return o aluno com a matrícula passada como parâmetro. null caso
     * nenhum aluno presente na tabela tenha a matrícula igual a passada como
     * parâmetro.
     */
    public Aluno get(Integer chave) {
        // TODO: implementar
        return null;
    }  

     public boolean containsKey(Integer chave) {
        //TODO implementar
        return false;
    }

    public boolean containsValue(Aluno aluno) {
        //TODO implementar
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
        ArrayList<Aluno> alunos = this.tabela[hash];
        
        Iterator<Aluno> it = alunos.iterator();
        Aluno atual = null;
        
        while (it.hasNext()) {
                atual = it.next();
                if (atual.getMatricula().equals(chave)) {
                    it.remove();
                    return atual;
                }
        }
        
        return atual;
    }  

}
