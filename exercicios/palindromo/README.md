# Palíndromo

Este repositório contém a implementação in-place de um verificador de palíndromos e sua respectiva análise assintótica.

## Análise de Pior Caso
O pior caso ocorre quando a palavra **é um palíndromo perfeito** (ex: "arara", conforme análise no código). O laço de repetição é forçado a rodar até a metade exata do array, executando o `return true` ao final.

### 1. Tabela de Custos
Seja $n$ o tamanho do array `palavra`.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `int i = 0;` | $c_1$ | $1$ |
| `int j = palavra.length - 1;` | $c_2$ | $1$ |
| `while (i < palavra.length / 2)`| $c_3$ | $\frac{n}{2} + 1$ |
| `if (palavra[i] != palavra[j])`| $c_4$ | $\frac{n}{2}$ |
| `return false;` | $c_5$ | $0$ |
| `i++;` | $c_6$ | $\frac{n}{2}$ |
| `j--;` | $c_7$ | $\frac{n}{2}$ |
| `return true;` | $c_8$ | $1$ |

### 2. Montando a Equação
Somando os custos e repetições de cada linha:
$$f(n) = c_1 + c_2 + c_3\left(\frac{n}{2} + 1\right) + c_4\left(\frac{n}{2}\right) + c_5(0) + c_6\left(\frac{n}{2}\right) + c_7\left(\frac{n}{2}\right) + c_8$$

Considerando, para fins de simplificação, que todas as constantes operacionais têm o mesmo custo ($c_1 = c_2 = \dots = c_8 = c$):
$$f(n) = c + c + \frac{c \cdot n}{2} + c + \frac{c \cdot n}{2} + 0 + \frac{c \cdot n}{2} + \frac{c \cdot n}{2} + c$$

Agrupando os termos fracionários e as constantes soltas, temos:
$$f(n) = 4\left(\frac{c \cdot n}{2}\right) + 4c$$
$$f(n) = 2 \cdot c \cdot n + 4c$$

Assumindo $c = 1$:
$$f(n) = 2n + 4$$

### 3. Prova Formal
Para provar que $f(n) \in \Theta(n)$, aplicamos a definição do limite assintótico exato:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo $f(n)$ pela nossa função e escolhendo as constantes $c_1 = 2$, $c_2 = 6$ e $n_0 = 1$ para fechar a inequação:
$$0 \le 2n \le 2n + 4 \le 6n, \forall n \ge 1$$

Como a inequação é verdadeira para qualquer $n \ge 1$, provamos formalmente que a função cresce de forma linear.

**C.Q.D. O algoritmo pertence à classe $\Theta(n)$.**