package util;

import java.util.List;
import java.util.Scanner;

import estruturas.DoublyLinkedList;
import estruturas.EstruturaDeDados;
import estruturas.Queue;
import estruturas.Stack;
import estruturas.Tree;
import manipulacaoarquivo.ManipulacaoArquivo;

public class Main {

    public static void main(String[] args) {
        ManipulacaoArquivo ma = new ManipulacaoArquivo();
        EstruturaDeDados<String> estrutura = null;
        Scanner scanner = new Scanner(System.in);

        List<String> lines = ma.lerArquivo("src/Arquivos/exec.txt");
        List<String> datas = ma.lerArquivo("src/Arquivos/dados.txt");

        String estruturaDeDados = lines.remove(0);

        switch (estruturaDeDados) {
            case "lista":
                System.out.println("Lista");
                estrutura = new DoublyLinkedList<>();
                break;
            case "pilha":
                System.out.println("Pilha");
                estrutura = new Stack<>();
                break;
            case "fila":
                System.out.println("Fila");
                estrutura = new Queue<>();
                break;
            case "arvore":
                System.out.println("Arvore");
                estrutura = new Tree<>();
                break;
            default:
                System.out.println("Estrutura errada [lista/pilha/fila/arvore]");
                return;
        }

        estrutura.addAll(datas);

        for (String line : lines) {
            if (estrutura == null) {
                System.out.println("Estrutura não inicializada.");
                scanner.close();
                return;
            }

            String[] operacao = line.split(";");
            String comando = operacao[0].toLowerCase(), dado = operacao[1];

            switch (comando) {
                case "inserir":
                    estrutura.add(dado);
                    System.out.println("INSERIDO -> " + dado);
                    break;
                case "remover":
                    if (estrutura.remove(dado)) {
                        System.out.println("REMOVIDO -> " + dado);
                    } else {
                        System.out.println("REMOVER -> Item não encontrado: " + dado);
                    }
                    break;
                case "buscar":
                    if (estrutura.seek(dado)) {
                        System.out.println("BUSCAR -> Encontrou: " + dado);
                    } else {
                        System.out.println("BUSCAR -> Não encontrou: " + dado);
                    }
                    break;
                case "imprimir":
                    System.out.println("IMPRIMIR -> " + estrutura.print());
                    break;
                default:
                    System.out.println("Comando não existe!");
            }
        }

        scanner.close();
    }

}
