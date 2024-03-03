import Arquivos.ManipulacaoArquivo;
import Estruturas.DoublyLinkedList;
import Estruturas.EstruturaDeDados;
import Estruturas.Queue;
import Estruturas.Tree;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        ManipulacaoArquivo ma = new ManipulacaoArquivo();
        EstruturaDeDados<String> estrutura = null;
        
        List<String> lines = ma.lerArquivo("exec.txt");
        List<String> datas = ma.lerArquivo("dados.txt");

        String estruturaDeDados = lines.remove(0);

        switch (estruturaDeDados){
            case "lista":
                System.out.println("Lista");
                estrutura = new DoublyLinkedList<>(datas);
                break;
            case "pilha":
                System.out.println("Pilha");
                //estrutura = new Stack<>(datas);
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
                        break;
                    case "REMOVER":
                        String dadoRemovido = estrutura.remove(dado);
                        if(dado != null){
                            System.out.println("Item Removido: " + dadoRemovido);
                        }else{
                            System.out.println("Remover Error: Item não encontrado! [" + dadoRemovido + "]");
                        }
                        break;
                    case "BUSCAR":
                        if(estrutura.seek(dado)){
                            System.out.println("Esse dado contém na lista!");
                        }else{
                            System.out.println("Esse dado não contém na lista!");
                        }
                        break;
                }
            }else {
                if(line.equals("IMPRIMIR")){
                    System.out.println(estrutura.print());
                }else{
                    System.out.println("Comando não existe!");
                }
            }
        }
        
    }

}