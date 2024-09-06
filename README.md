# TODO-lista

Programa TODO-list por Raiza Antoneli Cavalcante dos Santos. Cria, lê e exclui tarefas, organizando-as por categoria, status ou prioridade. O objetivo é organizar o ambiente de trabalho em tarefas e distribuí-las entre status To do, Doing e Done.

## Tecnologias utilizadas

**Imports:** 

```java
import java.io.BufferedReader; //Para tratar de forma mais dinâmica os dados escritos em um arquivo.txt
import java.io.BufferedWriter; //Para escrever de forma mais dinâmica os dados escritos em um arquivo.txt
import java.io.FileReader; //Para ler um arquivo e utilizar o Buffered
import java.io.FileWriter; //Para escrever um arquivo e utilizar o Buffered
import java.io.IOException; // Para tratar possíveis exceções durante operações de I/O
import java.util.ArrayList; // Para utilizar uma lista dinâmica que armazena tarefas
import java.util.List; // Interface que define métodos de manipulação de listas
import java.util.UUID; //Para gerar UUID aletório e atribuir a cada tarefa
import java.util.Scanner; //Para ler o que é escrito pelo usuário no terminal
```

## Comandos

#### Cria uma nova tarefa

```http
  nova-tarefa
```

| Parâmetro   | Tipo       | Descrição                           |
| :---------- | :--------- | :---------------------------------- |
| `nome` | `string` | Nome da tarefa |
| `descrição` | `string` | Descrição da tarefa |
| `data` | `string` | Data de término da tarefa |
| `prioridade` | `int` | Prioridade da tarefa de 1 a 5 |
| `categoria` | `string` | Categoria da tarefa |
| `status` | `string` | Status (To do, Doing, Done) da tarefa |

#### Exclui uma tarefa

```http
  excluir-tarefa
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `id`      | `string` | Id da tarefa que deseja excluir |

#### Lista todas as tarefas criadas.

```http
  tarefas
```

#### Lista todas as tarefas por prioridade.

```http
  tarefas prioridade
```

#### Lista todas as tarefas por categoria.

```http
  tarefas categoria
```

#### Lista todas as tarefas por status.

```http
  tarefas status
```

#### Finaliza a execução do programa.

```http
  para
```





