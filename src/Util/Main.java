package Util;

import Estruturas.DoublyLinkedList;
import Estruturas.Queue;
import Estruturas.Stack;
import Estruturas.Tree;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ManipulacaoArquivo ma = new ManipulacaoArquivo();
        EstruturaDeDados<String> estrutura = null;
        
        List<String> lines = ma.lerArquivo("src/Arquivos/exec.txt");
        List<String> datas = ma.lerArquivo("src/Arquivos/dados.txt");

        String estruturaDeDados = lines.remove(0);

        switch (estruturaDeDados){
            case "lista":
                System.out.println("Lista");
                estrutura = new DoublyLinkedList<>(datas);
                break;
            case "pilha":
                System.out.println("Pilha");
                estrutura = new Stack<>(datas);
                break;
            case "fila":
                System.out.println("Fila");
                estrutura = new Queue<>(datas);
                break;
            case "arvore":
                System.out.println("Arvore");
                estrutura = new Tree<>(datas);
                break;
            default:
                System.out.println("Estrutura errada [lista/pilha/fila/arvore]");
                break;
        }

        for(String line : lines){

            if(estrutura == null){
                throw new RuntimeException("Estrutura não inicializada.");
            }

            if(line.contains(";")){
                String[] operacao = line.split(";");
                String comando = operacao[0], dado = operacao[1];

                switch(comando){
                    case "INSERIR":
                        estrutura.add(dado);
                        if(dado != null){
                            System.out.println("INSERIR -> " + dado);
                        }
                        break;
                    case "REMOVER":
                        String dadoRemovido = estrutura.remove(dado);
                        if(dado != null){

                            if(dadoRemovido == null){
                                System.out.println("REMOVER -> Item não está na lista: " + dado);
                            }else{
                                System.out.println("REMOVIDO -> " + dadoRemovido);
                            }

                        }else{
                            System.out.println("REMOVER: Item não encontrado! [" + dadoRemovido + "]");
                        }
                        break;
                    case "BUSCAR":
                        if(estrutura.seek(dado)){
                            System.out.println("BUSCAR -> Encontrou: " + dado);
                        }else{
                            System.out.println("BUSCAR -> Não Encontrou: " + dado);
                        }
                        break;
                }
            }else {
                if(line.equals("IMPRIMIR")){
                    System.out.println("IMPRIMIR -> " + estrutura.print());
                }else{
                    System.out.println("Comando não existe!");
                }
            }
        }
        
    }

}