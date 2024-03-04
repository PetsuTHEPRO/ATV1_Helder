# Estrutura do Projeto de Estruturas de Dados
O projeto consiste em um programa que lê um arquivo chamado dados.txt para carregar as informações de entrada e depois um exec.txt. No Arquivo dados.txt contém todos os dados que vão ser carregados no momento da criação da estrutura de dados, ou seja, Esse arquivo contém informações sobre o tipo de estrutura de dados a ser utilizada (lista, fila, pilha ou árvore) e os comandos que serão executados nessa estrutura. Vamos detalhar cada parte:

## Arquivo dados.txt:
O arquivo dados.txt contém vários dados simples, cada um em uma linha separada. Esses dados serão lidos no momento em que a estrutura (lista, fila, pilha ou árvore) for instanciada. Vamos detalhar cada parte:

### Conteúdo do Arquivo:
O arquivo dados.txt pode conter qualquer quantidade de dados, desde que cada dado esteja em uma linha separada.
Exemplo de conteúdo:
```
moeda
livro
arroz
```

### Funcionamento:
Quando você cria uma instância da estrutura (por exemplo, uma lista), o programa lê o arquivo dados.txt.
Os dados presentes no arquivo são automaticamente adicionados à estrutura.
No exemplo acima, ao criar uma lista, ela já terá os elementos “moeda”, “livro” e “arroz”.

## Arquivo exec.txt:
O arquivo exec.txt é um arquivo de texto simples que contém as instruções para o programa.
A primeira linha do arquivo deve indicar o tipo de estrutura a ser utilizada (lista, fila, pilha ou arvore).
As linhas subsequentes contêm os comandos a serem executados na estrutura escolhida.
### Tipos de Estruturas:

O programa suporta quatro tipos de estruturas de dados:
- Lista: Uma lista duplamente encadeada.
- Fila: Uma fila (primeiro a entrar, primeiro a sair).
- Pilha: Uma pilha (último a entrar, primeiro a sair).
- Árvore: Uma árvore (uma árvore binária).

### Comandos Disponíveis:

Os comandos que podem ser executados dependem do tipo de estrutura escolhida:
- Inserir: Adiciona um elemento à estrutura.
- Buscar: Procura por um elemento na estrutura.
- Imprimir: Exibe os elementos da estrutura.
- Remover: Remove um elemento da estrutura (pode ser específico ou o último, dependendo da estrutura).

**Aviso Importante:** Os arquivos "dados.txt" e "exec.txt"(Encontrado no pacote Arquivos) podem ser modificados conforme necessário, desde que sigam a estrutura explicada anteriormente. Mantenha a consistência na formatação!

## Exemplo de Uso:
Suponhamos que o arquivo exec.txt contenha o seguinte:
```
lista
REMOVER; bola
IMPRIMIR
INSERIR; casa
IMPRIMIR;
BUSCAR; colher
```

### Nesse exemplo:
- O programa usará uma lista.
- Removerá o elemento “bola” da lista.
- Imprimirá os elementos da lista.
- Inserirá o elemento “casa” na lista.
- Imprimirá novamente os elementos da lista.
- Buscará o elemento “colher” na lista.

**Devido à natureza das estruturas de dados, inserir e remover funcionam de formas diferentes em cada tad.**

## Funcionamento específico de cada tad:

- Lista (duplamente encadeada)
  - Possui classe NoDuplo com dois campos, "anterior" e "próximo";
  - Inserir: Adiciona elemento ao final da lista;
  - Remover: Remove o elemento passado por parâmetro em qualquer posição da lista;

- Fila
  - Possui classe NoSimples com um campo "próximo";
  - Inserir: Adiciona elementoao final da fila;
  - Remover: Remove o elemento no inicio da fila;

- Pilha
  - Possui classe NoSimples com um campo "próximo";
  - Inserir: Adiciona elemento ao topo da pilha;
  - Remover: Remove o elemento no topo da pilha(Não possui remover um item específico);

- Arvore Binaria
  - Possui classe NoArvore com dois campos, "esquerda" e "direita";
  - Inserir: Adiciona elemento passando por um filtro de maior ou igual à direita e menor à
  esquerda, simulando uma árvore binária de busca. (existe método na tad para adicionar
  em algum local específico, só não foi implementado o funcionamento com a lógica dos
  comandos simples;
  - Remover: Remove o elemento passado por parâmetro em qualquer nó da arvore, exceto a raiz;

**Os comandos Buscar e Imprimir funcionam de forma semelhante nas 4 estruturas!**