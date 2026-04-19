# Tem Repetido

Este algoritmo verifica se um array não ordenado possui elementos duplicados, respeitando a restrição *in-place* (sem uso de arrays ou estruturas de dados auxiliares).

## Análise Analítica (Pior Caso)
O pior caso ocorre quando o array **não possui elementos repetidos**. O algoritmo é forçado a testar todas as combinações possíveis até o encerramento do laço.

### 1. Tabela de Custos
Seja $n$ o tamanho do array de entrada `v`.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `int i = 0;` | $c_1$ | $1$ |
| `i < v.length;` | $c_2$ | $n + 1$ |
| `i++;` | $c_3$ | $n$ |
| `int j = i + 1;` | $c_4$ | $n$ |
| `j < v.length;` | $c_5$ | $n + (n-1) + \dots + 1 = \frac{n(n+1)}{2}$ |
| `j++;` | $c_6$ | $(n-1) + (n-2) + \dots + 1 = \frac{(n-1)(n-1+1)}{2} = \frac{n(n-1)}{2}$ |
| `v[i] == v[j];`| $c_7$ | $(n-1) + (n-2) + \dots + 1 = \frac{(n-1)(n-1+1)}{2} = \frac{n(n-1)}{2}$ |
| `return true;` | $c_8$ | $0$ |
| `return false;` | $c_9$ | $1$ |

### 2. Montando a Equação $f(n)$
Somando os custos e repetições:
$$f(n) = c_1 + c_2(n+1) + c_3 \cdot n + c_4 \cdot n + c_5\left(\frac{n(n+1)}{2}\right) + c_6\left(\frac{n(n-1)}{2}\right) + c_7\left(\frac{n(n-1)}{2}\right) + c_9$$

Considerando que as operações possuem o mesmo custo base ($c_1 = c_2 = \dots = c$):
$$f(n) = c \left[ 1 + n + 1 + n + n + \frac{n^2}{2} + \frac{n}{2} + \frac{n^2}{2} - \frac{n}{2} + \frac{n^2}{2} - \frac{n}{2} + 1 \right]$$

Considerando $c=1$ e agrupando os termos fracionários e lineares, chegamos à função exata:
$$f(n) = \frac{3n^2}{2} + \frac{5n}{2} + 3$$

## Ordem de Crescimento
Simplificando $f(n)$, ignorando constantes e termos de menor grau, vemos que a função cresce na ordem de $n^2$. Ou seja, $f(n) = \Theta(n^2)$.

### Formalizando com o Limite Assintótico Exato
Para provar formalmente, utilizamos a inequação:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo as variáveis e escolhendo as constantes $c_1 = 1$, $c_2 = 7$ e $n_0 = 1$:
$$0 \le 1 \cdot n^2 \le \frac{3n^2}{2} + \frac{5n}{2} + 3 \le 7 \cdot n^2, \forall n \ge 1$$

Como a inequação se mantém verdadeira para todo $n \ge 1$, provamos que $f(n)$ cresce de forma quadrática.

**C.Q.D.**