# Troca Vizinhos

Este repositório contém a implementação in-place de um algoritmo que troca os elementos vizinhos de um array. Se o tamanho da sequência for ímpar, o último elemento é mantido em sua posição original.

## Análise Assintótica

O algoritmo percorre o array com um passo duplo (`i += 2`), o que reduz pela metade o número de iterações do laço principal.

### 1. Tabela de Custos
Seja $n$ o tamanho do array `nums`.

| Código | Custo | Repetições |
| :--- | :---: | :---: |
| `int i = 0;` | $c_1$ | $1$ |
| `i < nums.length - 1;` | $c_2$ | $\frac{n}{2} + 1$ |
| `i += 2;` | $c_3$ | $\frac{n}{2}$ |
| `int temp = nums[i];` | $c_4$ | $\frac{n}{2}$ |
| `nums[i] = nums[i+1];` | $c_5$ | $\frac{n}{2}$ |
| `nums[i+1] = temp;` | $c_6$ | $\frac{n}{2}$ |

### 2. Montando a Equação
Somando os custos e repetições de cada linha:
$$f(n) = c_1 \cdot 1 + c_2\left(\frac{n}{2} + 1\right) + c_3\left(\frac{n}{2}\right) + c_4\left(\frac{n}{2}\right) + c_5\left(\frac{n}{2}\right) + c_6\left(\frac{n}{2}\right)$$

Considerando que todas as constantes operacionais possuem o mesmo custo ($c_1 = c_2 = \dots = c_6 = c$):
$$f(n) = c + c\left(\frac{n}{2} + 1\right) + c\left(\frac{n}{2}\right) + c\left(\frac{n}{2}\right) + c\left(\frac{n}{2}\right) + c\left(\frac{n}{2}\right)$$
$$f(n) = 2c + \frac{5 \cdot c \cdot n}{2}$$

Assumindo $c = 1$ para simplificar a notação da prova formal:
$$f(n) = \frac{5n}{2} + 2$$

### 3. Prova Formal ($\Theta$)
Para provar que $f(n) \in \Theta(n)$, aplicamos a definição do limite assintótico exato:
$$0 \le c_1 \cdot g(n) \le f(n) \le c_2 \cdot g(n), \forall n \ge n_0$$

Substituindo $f(n)$ pela nossa função e escolhendo as constantes $c_1 = 1$, $c_2 = 5$ e $n_0 = 1$ para fechar a inequação:
$$0 \le 1 \cdot n \le \frac{5n}{2} + 2 \le 5 \cdot n, \forall n \ge 1$$

Como a inequação é verdadeira para $n \ge 1$, fica demonstrado que a função de tempo de execução cresce de forma linear.

**C.Q.D. O algoritmo pertence à classe $\Theta(n)$.**