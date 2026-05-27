# Identificação

* Nome: 
* Email (@ccc): 
* Matrícula: 

# Roteiro: Implementação de Pilha e Fila baseadas em Array

## Material Teórico 

[Pilha baseada em Array](https://joaoarthurbm.github.io/eda/posts/lifoarray/)

[Fila baseada em Array](https://joaoarthurbm.github.io/eda/posts/fifoarray/)

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

Este roteiro envolve a implementação das principais operações de pilha.

## A tarefa. 

### Implementação e testes


**Pilha e Fila.** Implemente os métodos da classe Pilha e Fila. A explicação do que fazer está como comentário no código. Seu objetivo é passar nos testes que disponibilizei.

### Restrições

    - Usar outra pilha auxiliar quando precisar. Não pode criar array ou iterar sobre o array.
    - A fila circular é de tamanho fixo e não deve sobrescrever ninguém. Quando chegar no limite da ocupação, lança exceção, como está descrito no método.

Ah...confira (sempre!) se você passa nos testes: `gradle test`.

Óbvio que você pode simplesmente copiar código da Internet e colar lá. Eu mesmo disponibilizo código. Mas, conselho, assim você não aprende :)
    
## Mais estudo

Implemente as seguintes questões no tst-eda:

* inverte_pilha_index
* max_pilha_index
* parênteses
 
## Entregando o lab

> Passo 0. Modifique o arquivo README. Coloque seu nome, email @ccc e matrícula nos lugares indicados. Se você não fizer isso, não considero que sua prova foi assinada e, portanto, não vou corrigir. Não mude a formatação da linha. Apenas inclua seus dados.

> Passo 1. Certifique-se **NO TERMINAL** de que sua solução compila e passa nos testes. Isso deve ser feito com os comandos do gradle (compileJava e test).

> Passo 2. Certifique-se de que você respondeu as perguntas teóricas onde foi indicado aqui no README.

> Passo 3. Submeta as suas modificações para o repositório

  * `git pull`
  * `git commit -m "entregando o lab"`
  * `git push origin main`
