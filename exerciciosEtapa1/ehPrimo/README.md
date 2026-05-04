# É Primo?

Este repositório contém um algoritmo in-place para verificar se um número inteiro é primo, respeitando a restrição de não utilizar nenhuma biblioteca matemática nativa do Java.

## Análise de Pior Caso
O pior caso de execução ocorre quando o número de entrada **um número primo**. Isso impede que o laço seja interrompido antecipadamente, forçando o algoritmo a testar a divisão por todos os números no intervalo de $2$ até $n-1$.

### 1. Tabela de Custos
Seja $n$ o valor do número avaliado.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `numero <= 1;` | $c_1$ | $1$ |
| `return false;` | $c_2$ | $0$ |
| `int i = 2;` | $c_3$ | $1$ |
| `i < numero;` | $c_4$ | $n - 1$ |
| `i++;` | $c_5$ | $n - 2$ |
| `numero % i == 0;` | $c_6$ | $n - 2$ |
| `return false;` | $c_7$ | $0$ |
| `return true;` | $c_8$ | $1$ |

### 2. Montando a Equação
Somando os custos e o número de repetições de cada linha, temos a função:
$$f(n) = c_1 \cdot 1 + c_3 \cdot 1 + c_4(n - 1) + c_5(n - 2) + c_6(n - 2) + c_8 \cdot 1$$

Considerando que as operações primitivas possuem um custo constante aproximado ($c_1 = c_3 = \dots = c_8 = c$):
$$f(n) = c \left[ 1 + 1 + n - 1 + n - 2 + n - 2 + 1 \right]$$

Agrupando os termos semelhantes e assumindo $c = 1$ para a prova de complexidade:
$$f(n) = 3n - 2$$

### 3. Prova Formal ($\Theta$)
Para provar formalmente a ordem de crescimento linear do algoritmo, aplicamos a definição do limite assintótico exato:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo $f(n)$ por $3n - 2$ e definindo nossa função de referência $g(n) = n$. Escolhemos as constantes $c_1 = 1$, $c_2 = 3$ e $n_0 = 1$ para equilibrar a inequação:
$$0 \le 1 \cdot n \le 3n - 2 \le 3 \cdot n, \forall n \ge 1$$

**C.Q.D. O algoritmo pertence à classe $\Theta(n)$.**