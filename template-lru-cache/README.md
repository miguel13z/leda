# Identificação

* Nome: 
* Email (@ccc): 
* Matrícula: 

# Cache e Estruturas de Dados Lineares: LRU

## Material Teórico 

[EDAs e Cache](https://joaoarthurbm.github.io/eda/posts/eda-cache/)

## O template

> Não altere o arquivo build.gradle

> O código java estará (ou você terá que colocar) no diretório **/src/main/java/**

> Seu código é tão bom quanto seus testes.

> Eu vou executar meus testes quando você submeter.

> Não mude nenhuma assinatura de método, nome de classe ou localização dos arquivos. Mas você pode/deve criar outros métodos e classes, desde que passem nos testes.

> Compilando: `javac *.java` em **/src/main/java/**

> Executando os testes: `java -ea ArrayListAsserts` em **/src/main/java/**

## Introdução

Este roteiro envolve a implementação da estratégia Menos Recentemente Utilizado / Least Recent Used (LRU) de cache eviction. Nessa estratégia, quando o cache está cheio e um elemento precisa entrar, o elemento que não foi usado por mais tempo deve ser removido. Os elementos que foram acessados recentemente vão para o final da fila, pois devem ser removidos por último. 

Funciona assim. Sempre que um elemento é utilizado/acessado, ele deve ir para o final da fila, pois está "quente". Assim, o início da fila guarda o elemento mais "frio" e que deve sair caso preciso, porque não é acessado há mais tempo.

Veja que se um elemento for o próximo a sair, mas for acessado, ele sai do início da fila e vai para o final, porque se tornou "quente". De novo, sempre que um elemento é acessado no cache, ele fica quente e deve ir para o final da fila. **Importante: mover um elemento para o final da fila deve ser feito em O(1)!**

Analise o teste abaixo para entender a especificação desse comportamento.

```java
       LRUEvictionStrategy lrucache = new LRUEvictionStrategy(4);
        assert lrucache.getNextEviction() == null;
        assert lrucache.size() == 0;
        assert lrucache.get("a").equals("miss");

        // cache status: ["a", null, null, null]
        assert lrucache.getNextEviction() == null;
        assert lrucache.size() == 1;
        assert lrucache.get("a").equals("hit");
        assert lrucache.size() == 1;

        assert lrucache.get("b").equals("miss");
        assert lrucache.getNextEviction() == null;
        assert lrucache.get("c").equals("miss");
        assert lrucache.get("d").equals("miss");

        // cache status: ["a", "b", "c", "d"]
        assert lrucache.getNextEviction().equals("a");

        assert lrucache.get("b").equals("hit");
        // cache status: ["a", "c", "d", "b"]
        assert lrucache.getNextEviction().equals("a");
        
        assert lrucache.get("a").equals("hit");
        // cache status: ["c", "d", "b", "a"]

        assert lrucache.get("e").equals("miss");
        // cache status: ["d", "b", "a", "e"]
        assert lrucache.getNextEviction().equals("d");

        assert lrucache.get("c").equals("miss");
        // cache status: ["b", "a", "e", "c"]

        assert lrucache.getNextEviction().equals("b");
        assert lrucache.get("e").equals("hit");
        // cache status: ["b", "a", "c", "e"]
        assert lrucache.getNextEviction().equals("b");

        assert lrucache.get("x").equals("miss");
        // cache status: ["a", "c", "e", "x"]

        assert lrucache.get("y").equals("miss");
        // cache status: ["c", "e", "x", "y"]

        assert lrucache.get("z").equals("miss");
        // cache status: ["e", "x", "y", "z"]

        assert lrucache.getNextEviction().equals("e");
        assert lrucache.get("w").equals("miss");
        // cache status: ["x", "y", "z", "w"]

        assert lrucache.size() == 4;
        assert lrucache.getNextEviction().equals("x");
```

## A tarefa. 

### Implementação e testes


Implemente os métodos da classe **LRUEvictionStrategy**, **LRUCache** e **LinkedList**. 

Importante: entenda os testes. Leia. Compreenda. Faça mais testes. Testes são uma excelente forma de especificação de como seu algoritmo deve funcionar.


### Restrições

    - Você deve implementar com uma LinkedList e apenas essa estrutura. O código foi disponibilizado, exceto pelo método `moveToHead`, que você deve implementar.
    
    - A busca por um elemento no cache é O(n) ainda porque não estamos usando outra estrutura além da LinkedList.
    
    - Adição, remoção e mover um elemento para o final da linkedlist **deve ser O(1)**.

    - Seu cache deve ter o tamanho fixo, mesmo sendo implementado com uma linked list.

Ah...confira (sempre!) se você passa nos testes: `java -ea ArrayListAsserts`.
