# Soma Dois (Two Sum)

Este repositório contém a implementação in-place de um algoritmo para encontrar um par de elementos em um array cuja soma seja igual a um valor `target`.

## Análise de Pior Caso
O pior caso ocorre quando nenhuma soma resulta no `target`, forçando os laços a testarem absolutamente todas as combinações possíveis do array antes de retornar um array vazio.

### 1. Tabela de Custos
Seja $n$ o tamanho do array de entrada `v`.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `int i = 0;` | $c_1$ | $1$ |
| `i < v.length;` | $c_2$ | $n + 1$ |
| `i++;` | $c_3$ | $n$ |
| `int j = i + 1;` | $c_4$ | $n$ |
| `j < v.length;` | $c_5$ | $n + (n-1) + \dots + 1 = \frac{n(n+1)}{2} = \frac{n^2+n}{2}$ |
| `j++;` | $c_6$ | $(n-1) + (n-2) + \dots + 1 = \frac{n^2-n}{2}$ |
| `v[i] + v[j] == target;`| $c_7$ | $(n-1) + (n-2) + \dots + 1 = \frac{n^2-n}{2}$ |
| `int[] res = new int[2];`| $c_8$ | $0$ |
| `res[0] = v[i];` | $c_9$ | $0$ |
| `res[1] = v[j];` | $c_{10}$ | $0$ |
| `return res;` | $c_{11}$ | $0$ |
| `return new int[0];` | $c_{12}$ | $1$ |

### 2. Montando a Equação
Somando os custos e repetições de cada linha:
$$f(n) = c_1 + c_2(n+1) + c_3 \cdot n + c_4 \cdot n + c_5\left(\frac{n^2+n}{2}\right) + c_6\left(\frac{n^2-n}{2}\right) + c_7\left(\frac{n^2-n}{2}\right) + c_{12}$$

Considerando, para fins de simplificação, que todas as operações executadas possuem um mesmo custo de máquina ($c_1 = c_2 = \dots = c_{12} = c$):
$$f(n) = c \left[ 1 + n + 1 + n + n + \frac{n^2+n}{2} + \frac{n^2-n}{2} + \frac{n^2-n}{2} + 1 \right]$$

Agrupando os termos semelhantes e assumindo $c=1$:
$$f(n) = 3 + 3n + \frac{n^2}{2} + \frac{n}{2} + n^2 - n$$

Chegamos à função exata de tempo de execução:
$$f(n) = \frac{3n^2}{2} + \frac{5n}{2} + 3$$

### 3. Prova Formal ($\Theta$)
Para demonstrar formalmente que a função pertence à classe de complexidade quadrática, aplicamos a definição matemática do limite assintótico exato:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo nossa função $f(n)$ e a função de referência $g(n) = n^2$, e escolhendo as constantes $c_1 = 1$, $c_2 = 7$ e $n_0 = 1$:
$$0 \le 1 \cdot n^2 \le \frac{3n^2}{2} + \frac{5n}{2} + 3 \le 7 \cdot n^2, \forall n \ge 1$$

Como a inequação é matematicamente verdadeira para qualquer valor de $n \ge 1$, fica provado que $f(n)$ cresce na ordem de $n^2$.

**C.Q.D. O algoritmo pertence à classe $\Theta(n^2)$.**