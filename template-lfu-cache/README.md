# Identificação

* Nome: 
* Email (@ccc): 
* Matrícula: 

# Cache e Estruturas de Dados Lineares: LFU

## Material Teórico 

[EDAs e Cache](https://joaoarthurbm.github.io/eda/posts/eda-cache/)

## O template

> Não altere o arquivo build.gradle

> O código java estará (ou você terá que colocar) no diretório **/src/main/java/**

> Os testes estarão (ou você terá que incluir) no diretório **/src/test/java/**

> Seu código é tão bom quanto seus testes.

> Eu vou executar meus testes quando você submeter.

> Não mude nenhuma assinatura de método, nome de classe ou localização dos arquivos. Mas você pode/deve criar outros métodos e classes, desde que passem nos testes.

> Compilando: `gradle compileJava` na raiz do projeto.

> Executando os testes: `gradle test` na raiz do projeto.

## Introdução

Este roteiro envolve a implementação da estratégia Menos Frequentemente Utilizado / Least Frequently Used (LFU) de cache eviction. Nessa estratégia, quando o cache está cheio e um elemento precisa entrar, o elemento menos acessado deve ser removido. Os elementos que foram mais acessados vão para o final da fila, pois devem ser removidos por último. 

Funciona assim. Sempre que um elemento é utilizado/acessado, sua frequência de uso deve ser incrementada e ele deve ser reposicionado na fila para manter a ordem conforme a frequência. Os elementos considerados "menos acessados" são guardados no ínicio da fila e devem ser removidos primeiro, caso preciso, porque são acessados com menos frequência.

Veja que se um elemento for o próximo a sair, mas for acessado muitas vezes, sua frequência aumenta e ele é reposicionado na fila, pois se tornou "mais acessado". Isso garante sua permanência no cache enquanto continuar sendo acessado frequentemente.

Analise o teste abaixo para entender a especificação desse comportamento.

```java
        LFUEvictionStrategy lfucache = new LFUEvictionStrategy(4);
        assertNull(lfucache.getNextEviction());
        assertEquals(0, lfucache.size());

        assertEquals("miss", lfucache.get("a"));
        // cache status: [<"a", 1>, null, null, null]
        assertNull(lfucache.getNextEviction());
        assertEquals(1, lfucache.size());

        assertEquals("hit", lfucache.get("a"));
        assertEquals("hit", lfucache.get("a"));
        // cache status: [<"a", 3>, null, null, null]
        assertEquals(1, lfucache.size());

        assertEquals("miss", lfucache.get("b"));
        assertEquals("miss", lfucache.get("c"));
        // cache status: [<"c", 1>, <"b", 1>, <"a", 3>, null]
        assertNull(lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("d"));
        // cache status: [<"d", 1>, <"c", 1>, <"b", 1>, <"a", 3>]
        assertEquals("d", lfucache.getNextEviction());

        assertEquals("hit", lfucache.get("d"));
        assertEquals("hit", lfucache.get("d"));
        assertEquals("hit", lfucache.get("d"));
        // cache status: [<"c", 1>, <"b", 1>, <"a", 3>, <"d", 4>]
        // "d" foi para o final da fila, pois é o elemento mais acessado
        // e "c" passa a ser o menos acessado.
        assertEquals("c", lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("e"));
        // cache status: [<"e", 1>, <"b", 1>, <"a", 3>, <"d", 4>]
        // "c" teve que sair para entrada do "e", pois "c" é o menos acessado da fila.
        assertEquals("e", lfucache.getNextEviction());
        assertEquals(4, lfucache.size());

        assertEquals("hit", lfucache.get("e"));
        // cache status: [<"b", 1>, <"e", 2>, <"a", 3>, <"d", 4>]
        // trocamos o "e" e "b", pois "e" foi mais acessado que "b"
        // e "b" passa a ser o elemento menos acessado da fila.
        assertEquals("b", lfucache.getNextEviction());

        assertEquals("miss", lfucache.get("c"));
        // cache status: [<"c", 1>, <"e", 2>, <"a", 3>, <"d", 4>]
        // "b" teve que sair para "c" voltar, pois "b" é o menos acessado da fila.
        assertEquals("c", lfucache.getNextEviction());

        assertEquals("hit", lfucache.get("e"));
        assertEquals("hit", lfucache.get("e"));
        // cache status: [<"c", 1>, <"a", 3>, <"e", 4>, <"d", 4>]
        assertEquals("c", lfucache.getNextEviction());
        
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        assertEquals("hit", lfucache.get("c"));
        // cache status: [<"a", 3>, <"e", 4>, <"d", 4>, <"c", 5>]
        // "c" foi para o final da fila, pois é o elemento mais acessado
        // e "a" passa a ser o menos acessado.
        assertEquals("a", lfucache.getNextEviction());
        assertEquals(4, lfucache.size());
```

## A tarefa. 

### Implementação e testes


Implemente os métodos da classe **LFUEvictionStrategy**, **LFUCache** e **LinkedList**. 

Importante: entenda os testes. Leia. Compreenda. Faça mais testes. Testes são uma excelente forma de especificação de como seu algoritmo deve funcionar.


### Restrições

    - Você deve implementar com uma LinkedList e apenas essa estrutura. O código foi disponibilizado, exceto pelo método `sortByFrequency`, que você deve implementar.
    
    - A busca por um elemento no cache é O(n) ainda porque não estamos usando outra estrutura além da LinkedList.
    
    - Adição e remoção de um elemento da linkedlist **deve ser O(1)**.

    - Inserção de um elemento ordenado pela frequência na linkedlist **deve ser O(n)**.

    - Seu cache deve ter o tamanho fixo, mesmo sendo implementado com uma linked list.

Ah...confira (sempre!) se você passa nos testes: `gradle test`.
    
## Entregando o lab

> Passo 0. Modifique o arquivo README. Coloque seu nome, email @ccc e matrícula nos lugares indicados. Se você não fizer isso, não considero que sua prova foi assinada e, portanto, não vou corrigir. Não mude a formatação da linha. Apenas inclua seus dados.

> Passo 1. Certifique-se **NO TERMINAL** de que sua solução compila e passa nos testes. Isso deve ser feito com os comandos do gradle (compileJava e test).

> Passo 2. Certifique-se de que você respondeu as perguntas teóricas onde foi indicado aqui no README.

> Passo 3. Submeta as suas modificações para o repositório

  * `git pull`
  * `git commit -m "entregando o lab"`
  * `git push origin main`
