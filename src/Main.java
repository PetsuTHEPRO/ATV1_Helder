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
        
        List<String> linhas;
        List<String> dados = ma.lerArquivo("dados.txt");

        linhas = ma.lerArquivo("exec.txt");

        String ed = linhas.get(0);

        switch (ed){
            case "lista":
                System.out.println("Lista");
                estrutura = new DoublyLinkedList<>(dados);
                break;
            case "pilha":
                System.out.println("Pilha");
                //estrutura = new Stack<>(dados);
                break;
            case "fila":
                System.out.println("Fila");
                estrutura = new Queue<>(dados);
                break;
            case "arvore":
                System.out.println("Arvore");
                estrutura = new Tree<>(dados);
                break;
            default:
                System.out.println("Estrutura errada [lista/pilha/fila/arvore]");
                break;
        }

        for(int i = 0; i < linhas.size(); i++){
            if(i != 0){
                if(linhas.get(i).contains(";")){
                    String comando[] = linhas.get(i).split(";");
                    switch(comando[0]){
                        case "INSERIR":
                            estrutura.add(comando[1]);
                            break;
                        case "REMOVER":
                            String dado = estrutura.remove(comando[1]);
                            if(dado != null){
                                System.out.println("Item Removido: " + dado);
                            }else{
                                System.out.println("Remover Error: Item não encontrado! [" + comando[1] + "]");
                            }
                            break;
                        case "BUSCAR":
                            if(estrutura.seek(comando[1])){
                                System.out.println("Esse dado contém na lista!");
                            }else{
                                System.out.println("Esse dado não contém na lista!");
                            }
                            break;
                    }
                }else{
                    System.out.println(estrutura.print());
                }
            }
        }
        
    }

}