# Identificação

* Nome:
* Email (@ccc):
* Matrícula:

# Cache e Estruturas de Dados Lineares

## Material Teórico

[EDAs e Cache](https://joaoarthurbm.github.io/eda/posts/eda-cache/)

## O template

> O código java estará (ou você terá que colocar) no diretório **/src/main/java/**

> Os testes estarão (ou você terá que incluir) no diretório **/src/main/java/** no formato de asserts.

> Seu código é tão bom quanto seus testes.

> Eu vou executar meus testes quando você submeter.

> Não mude nenhuma assinatura de método, nome de classe ou localização dos arquivos. Mas você pode/deve criar outros métodos e classes, desde que passem nos testes.

> Compilando: `javac *.java` em **/src/main/java/**

> Executando os testes: `java -ea FIFOCacheAsserts` em **/src/main/java/**

## Introdução

Este roteiro envolve a implementação de estratégias de cache eviction discutidas no material teórico. Vamos começar com FIFO.

## A tarefa.

### Implementação e testes

**FIFOEvictionStrategy.** Implemente os métodos da classe FIFOEvictionStrategy. A estratégia FIFO de cache remove o mais antigo da fila quando preciso. Você deve usar uma fila que você mesmo implementou. Ou seja, não pode usar classes do collections framework de Java. Use sua classe Fila. Coloque no mesmo diretório que a classe
FIFOEvictionStrategy.

Importante: entenda os testes. Leia. Compreenda. Faça mais testes. Testes são uma excelente forma de especificação de como seu algoritmo deve funcionar.

### Restrições

    - Sua fila tem que ter o tamanho fixo. Não pode crescer.

    - Não pode usar nenhuma abstração do collections framework.

Ah...confira (sempre!) se você passa nos testes: `java -ea FIFOCacheAsserts`.
