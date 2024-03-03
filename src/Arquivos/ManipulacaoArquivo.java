package Arquivos;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class ManipulacaoArquivo {

    private List<String> linhas;
    private Path arquivo;
    public ManipulacaoArquivo(){
        linhas = new ArrayList<>();
    }

    public List<String> lerArquivo(String path){

        arquivo = Paths.get(path);

        try{
            linhas = Files.readAllLines(arquivo);
        }catch(IOException io){
            io.printStackTrace();
        }

        return linhas;
    }

}
