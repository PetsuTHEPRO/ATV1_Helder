package Estruturas;

import Util.EstruturaDeDados;

import java.util.List;

class NodoArvore<T> {

    private T elemento;
    private NodoArvore<T> noEsquerdo;
    private NodoArvore<T> noDireito;

    public void NodoArvore(){
        elemento = null;
        noDireito = null;
        noEsquerdo = null;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoArvore<T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NodoArvore<T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public NodoArvore<T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(NodoArvore<T> noDireito) {
        this.noDireito = noDireito;
    }
}

public class Tree<T extends Comparable<T>> implements EstruturaDeDados<T> {

    private NodoArvore<T> raiz;

    public Tree(List<T> dados){
        raiz = null;
        criarEstrutura(dados);
    }

    public void add(T elemento) {
        NodoArvore<T> noAtual = new NodoArvore<>();
        noAtual.setElemento(elemento);

        if (raiz == null) {
            this.raiz = noAtual;
        } else {
            NodoArvore<T> atual = this.raiz;
            while (true) {
                int comparacao = noAtual.getElemento().compareTo(atual.getElemento());
                if (comparacao < 0) {
                    if (atual.getNoEsquerdo() != null) {
                        atual = atual.getNoEsquerdo();
                     } else {
                        atual.setNoEsquerdo(noAtual);
                        break;
                    }
                } else {
                    if (atual.getNoDireito() != null) {
                        atual = atual.getNoDireito();
                    } else {
                        atual.setNoDireito(noAtual);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void criarEstrutura(List<T> dados) {

        for(T dado : dados){
            add(dado);
        }

    }

    @Override
    public T remove(T elemento) {
        NodoArvore<T> atual = this.raiz;
        NodoArvore<T> paiAtual = null;

        // Encontrar o nó a ser removido
        while (atual != null) {
            int comparacao = elemento.compareTo(atual.getElemento());
            if (comparacao == 0) {
                break; // Elemento encontrado
            } else if (comparacao < 0) {
                paiAtual = atual;
                atual = atual.getNoEsquerdo();
            } else {
                paiAtual = atual;
                atual = atual.getNoDireito();
            }
        }

        if (atual == null) {
            return null; // Elemento não encontrado
        }

        // Caso 1: Sem filhos ou apenas um filho
        if (atual.getNoEsquerdo() == null) {
            if (paiAtual == null) {
                this.raiz = atual.getNoDireito();
            } else if (paiAtual.getNoEsquerdo() == atual) {
                paiAtual.setNoEsquerdo(atual.getNoDireito());
            } else {
                paiAtual.setNoDireito(atual.getNoDireito());
            }
        } else if (atual.getNoDireito() == null) {
            if (paiAtual == null) {
                this.raiz = atual.getNoEsquerdo();
            } else if (paiAtual.getNoEsquerdo() == atual) {
                paiAtual.setNoEsquerdo(atual.getNoEsquerdo());
            } else {
                paiAtual.setNoDireito(atual.getNoEsquerdo());
            }
        } else {
            // Caso 2: Dois filhos
            T sucessor = encontrarSucessor(atual.getNoDireito());
            atual.setElemento(sucessor);
            atual.setNoDireito(removerSucessor(atual.getNoDireito()));
        }

        return elemento;
    }

    private T encontrarSucessor(NodoArvore<T> atual) {
        while (atual.getNoEsquerdo() != null) {
            atual = atual.getNoEsquerdo();
        }
        return atual.getElemento();
    }

    private NodoArvore<T> removerSucessor(NodoArvore<T> atual) {
        if (atual.getNoEsquerdo() == null) {
            return atual.getNoDireito();
        }
        atual.setNoEsquerdo(removerSucessor(atual.getNoEsquerdo()));
        return atual;
    }

    @Override
    public boolean seek(T elemento) {
        return seekTree(raiz, elemento);
    }

    private boolean seekTree(NodoArvore<T> atual, T elemento) {
        if(atual == null){
            return false;
        }

        if(atual.getElemento().equals(elemento)){
            return true;
        }

        return seekTree(atual.getNoEsquerdo(), elemento) || seekTree(atual.getNoDireito(), elemento);
    }

    @Override
    public StringBuilder print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        emOrdem(raiz, sb);
        sb.append("]");
        return sb;
    }

    private void emOrdem(NodoArvore<T> atual, StringBuilder sb){
        if (atual != null){
            emOrdem(atual.getNoEsquerdo(), sb);
            sb.append(atual.getElemento()).append(" ");
            emOrdem(atual.getNoDireito(), sb);
        }
    }

    private void preOrdem(NodoArvore<T> atual, StringBuilder sb){
        if (atual != null){
            sb.append(atual.getElemento()).append(" ");
            preOrdem(atual.getNoEsquerdo(), sb);
            preOrdem(atual.getNoDireito(), sb);
        }
    }

    private void posOrdem(NodoArvore<T> atual, StringBuilder sb){
        if (atual != null){
            posOrdem(atual.getNoEsquerdo(), sb);
            posOrdem(atual.getNoDireito(), sb);
            sb.append(atual.getElemento()).append(" ");
        }
    }

}
