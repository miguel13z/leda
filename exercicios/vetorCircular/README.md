# Vetor Circular

Este algoritmo recebe um array e imprime seus elementos de forma circular até atingir uma quantidade $N$ estipulada, retornando ao início do array sempre que o limite é alcançado, respeitando a restrição *in-place*.

## Análise Analítica

### 1. Tabela de Custos
Seja $n$ a variável `quantidadeElementos`, que dita o limite do laço.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `String out = "";` | $c_1$ | $1$ |
| `int i = 0;` | $c_2$ | $1$ |
| `i < quantidadeElementos;` | $c_3$ | $n + 1$ |
| `i++;` | $c_4$ | $n$ |
| `out += array[i % array.length] + " ";`| $c_5$ | $n$ |
| `return out;` | $c_6$ | $1$ |

### 2. Montando a Equação $f(n)$
Somando os custos e agrupando os termos:
$$f(n) = c_1 \cdot 1 + c_2 \cdot 1 + c_3(n + 1) + c_4 \cdot n + c_5 \cdot n + c_6 \cdot 1$$

Considerando que as operações primitivas possuem um custo constante aproximado ($c_1 = c_2 = \dots = c_6 = c$):
$$f(n) = c \left[ 1 + 1 + n + 1 + n + n + 1 \right]$$

Agrupando os termos e assumindo $c = 1$ para a prova de complexidade:
$$f(n) = 3n + 4$$

## Ordem de Crescimento
Simplificando $f(n)$, ignorando constantes, temos que $f(n) = \Theta(n)$.

### Formalizando com o Limite Assintótico Exato
Para provar formalmente, utilizamos a inequação:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo $f(n)$ por $3n + 4$, nossa função de referência $g(n) = n$, e escolhendo as constantes $c_1 = 3$, $c_2 = 7$ e $n_0 = 1$:
$$0 \le 3 \cdot n \le 3n + 4 \le 7 \cdot n, \forall n \ge 1$$

Como a inequação se mantém verdadeira para todo $n \ge 1$, fica provado que $f(n)$ cresce de forma linear.

**C.Q.D.**