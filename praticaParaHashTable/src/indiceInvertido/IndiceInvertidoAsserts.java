package indiceInvertido;

import java.util.*;

public class IndiceInvertidoAsserts {

    public static void main(String[] args) {
        
        IndiceInvertido indice = new IndiceInvertido();

        // 1. O índice nasce vazio
        assert indice.search("estrutura") == null : "Erro: Busca inicial deve retornar null";

        // 2. Adicionando o primeiro documento
        indice.addDocument("doc1", "Um indice invertido e uma estrutura muito utilizada");
        
        // Verifica se o mapeamento básico funcionou
        assert indice.search("indice").size() == 1 : "Erro no tamanho (doc1 - indice)";
        assert indice.search("indice").get(0).equals("doc1") : "Erro no documento retornado (doc1 - indice)";
        
        assert indice.search("estrutura").size() == 1 : "Erro no tamanho (doc1 - estrutura)";
        assert indice.search("estrutura").get(0).equals("doc1") : "Erro no documento retornado (doc1 - estrutura)";

        // 3. Adicionando um segundo documento com palavras compartilhadas
        indice.addDocument("doc2", "Essa estrutura e muito utilizada em bancos de dados");
        
        // "estrutura" agora deve estar em ambos os documentos
        assert indice.search("estrutura").size() == 2 : "Erro: 'estrutura' deveria estar em 2 docs";
        assert indice.search("estrutura").contains("doc1") : "Faltou doc1 em 'estrutura'";
        assert indice.search("estrutura").contains("doc2") : "Faltou doc2 em 'estrutura'";
        
        // "bancos" só existe no doc2
        assert indice.search("bancos").size() == 1 : "Erro: 'bancos' deveria estar em 1 doc";
        assert indice.search("bancos").get(0).equals("doc2") : "Erro no documento retornado (doc2 - bancos)";

        // 4. Adicionando um terceiro documento (Teste da Regra do Conjunto/Set)
        // A palavra "texto" aparece 3 vezes no mesmo documento.
        indice.addDocument("doc3", "texto e mais texto e muito texto");
        
        // O doc3 só pode aparecer UMA VEZ na lista da palavra "texto"
        assert indice.search("texto").size() == 1 : "Erro: O doc3 deve aparecer apenas uma vez para a palavra 'texto', independente da frequência";
        assert indice.search("texto").get(0).equals("doc3") : "Erro no documento retornado (doc3 - texto)";
        
        // A palavra "muito" agora existe nos docs 1, 2 e 3
        assert indice.search("muito").size() == 3 : "Erro: 'muito' deveria estar em 3 docs";
        assert indice.search("muito").containsAll(Arrays.asList("doc1", "doc2", "doc3")) : "Lista de docs para 'muito' esta incorreta";

        // 5. Testando Miss (Palavra inexistente)
        assert indice.search("xpto") == null : "Erro: Palavra inexistente deve retornar null";

        System.out.println("Todos os testes passaram!");
    }
}