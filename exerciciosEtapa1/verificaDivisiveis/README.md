# Verifica Divisíveis

Este algoritmo verifica se existe algum par de elementos $(x, y)$ em um array não ordenado tal que um seja divisível pelo outro. A restrição do problema proíbe o uso de arrays auxiliares e bibliotecas.

## Análise Analítica (Pior Caso)
O pior caso ocorre quando não existe nenhum par de números divisíveis entre si no array. Isso obriga as estruturas de repetição a iterarem por todas as combinações possíveis até o final do laço.

### 1. Tabela de Custos
Seja $n$ o tamanho do array `v`.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `int i = 0;` | $c_1$ | $1$ |
| `i < v.length - 1;` | $c_2$ | $n$ |
| `i++;` | $c_3$ | $n - 1$ |
| `int j = i + 1;` | $c_4$ | $n - 1$ |
| `j < v.length;` | $c_5$ | $n + (n-1) + \dots + 2 = \frac{(n-1)(n+2)}{2}$ |
| `j++;` | $c_6$ | $(n-1) + (n-2) + \dots + 1 = \frac{n(n-1)}{2}$ |
| `if (v[i] != 0 && ...);`| $c_7$ | $(n-1) + (n-2) + \dots + 1 = \frac{n(n-1)}{2}$ |
| `return true;` | $c_8$ | $0$ |
| `return false;` | $c_9$ | $1$ |

### 2. Montando a Equação $f(n)$
Somando todos os custos e repetições de cada linha:
$$f(n) = c_1 + c_2 \cdot n + c_3(n - 1) + c_4(n - 1) + c_5\left(\frac{(n-1)(n+2)}{2}\right) + c_6\left(\frac{n(n-1)}{2}\right) + c_7\left(\frac{n(n-1)}{2}\right) + c_9$$

Assumindo que todas as operações primitivas possuem um custo constante de máquina equivalente ($c_1 = c_2 = \dots = c_9 = c$):
$$f(n) = c \left[ 1 + n + n - 1 + n - 1 + \frac{n^2+n-2}{2} + \frac{n^2-n}{2} + \frac{n^2-n}{2} + 1 \right]$$

Considerando $c = 1$ e agrupando os termos semelhantes (lineares, quadráticos e constantes):
$$f(n) = n^2 + 2n + \frac{n^2}{2} + n - \frac{n}{2} - 1$$

$$f(n) = \frac{3n^2}{2} + \frac{5n}{2} - 1$$

## Ordem de Crescimento
Simplificando a função $f(n)$ por meio da omissão dos coeficientes constantes e dos termos de menor grau, determina-se que o algoritmo possui ordem de crescimento quadrática: $f(n) = \Theta(n^2)$.

### Formalizando com o Limite Assintótico Exato
Para comprovar formalmente a classe de complexidade, aplicamos a definição do limite assintótico exato:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo $f(n)$ por nossa equação resolvida, a função de referência $g(n) = n^2$, e selecionando as constantes $c_1 = 1$, $c_2 = 7$ e o valor inicial $n_0 = 1$:
$$0 \le 1 \cdot n^2 \le \frac{3n^2}{2} + \frac{5n}{2} - 1 \le 7 \cdot n^2, \forall n \ge 1$$

Como a inequação sanduíche permanece coerente para todo $n \ge 1$, está matematicamente provado que a função de tempo de execução cresce de forma quadrática.

**C.Q.D.**