# Bubble Sort

Este algoritmo implementa o método de ordenação *Bubble Sort*. A solução respeita a restrição *in-place*, não utilizando arrays auxiliares. 

## Análise Analítica
O Pior Caso ocorre quando o array está **ordenado em ordem decrescente**. Isso força a condição de troca (`array[j] > array[j + 1]`) a ser verdadeira em todas as comparações possíveis, acionando as operações de *troca* no seu limite máximo.

### 1. Tabela de Custos
Seja $n$ o tamanho do array.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `int i = 1;` | $c_1$ | $1$ |
| `i < array.length;` | $c_2$ | $n$ |
| `i++;` | $c_3$ | $n - 1$ |
| `int j = 0;` | $c_4$ | $n - 1$ |
| `j < array.length - i;` | $c_5$ | $n + (n-1) + \dots + 2 = \frac{(n-1)(n+2)}{2}$ |
| `j++;` | $c_6$ | $(n-1) + (n-2) + \dots + 1 = \frac{n(n-1)}{2}$ |
| `if (array[j] > array[j+1]);`| $c_7$ | $(n-1) + (n-2) + \dots + 1 = \frac{n(n-1)}{2}$ |
| `int aux = array[j];` | $c_8$ | $\frac{n(n-1)}{2}$ |
| `array[j] = array[j+1];` | $c_9$ | $\frac{n(n-1)}{2}$ |
| `array[j+1] = aux;` | $c_{10}$ | $\frac{n(n-1)}{2}$ |
| `return array;` | $c_{11}$ | $1$ |

**OBS:** As operações de troca ($c_8$, $c_9$ e $c_{10}$) poderiam se agrupar e ter um custo $c_x$ para simplificar os cálculos.

### 2. Montando a Equação $f(n)$
Somando os custos e convertendo as frações, assumindo um custo constante unificado $c=1$:
$$f(n) = 1 + n + (n - 1) + (n - 1) + \left(\frac{n^2}{2} + \frac{n}{2} - 1\right) + 5 \left(\frac{n^2}{2} - \frac{n}{2}\right) + 1$$

Agrupando os termos quadráticos ($0.5n^2 + 2.5n^2 = 3n^2$), os termos lineares ($3n + 0.5n - 2.5n = n$) e as constantes ($1 - 1 - 1 - 1 + 1 = -1$), chegamos à função exata:
$$f(n) = 3n^2 + n - 1$$

## Ordem de Crescimento
Simplificando a função $f(n)$ (ignorando as constantes e o termo linear de menor grau), determina-se que o algoritmo pertence à classe de complexidade quadrática: $f(n) = \Theta(n^2)$.

### Formalizando com o Limite Assintótico Exato
Aplicando a definição de limite assintótico exato:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo $f(n)$ por $3n^2 + n - 1$ e a função de referência $g(n) = n^2$. Escolhendo as constantes $c_1 = 1$, $c_2 = 5$ e $n_0 = 1$:
$$0 \le 1 \cdot n^2 \le 3n^2 + n - 1 \le 5 \cdot n^2, \forall n \ge 1$$

Como a inequação se mantém verdadeira para $n \ge 1$, a ordem de crescimento quadrática está provada matematicamente.

**C.Q.D.**