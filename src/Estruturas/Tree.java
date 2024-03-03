package Estruturas;

import java.util.List;

public class Tree<T extends Comparable<T>> implements EstruturaDeDados<T>{

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
        return null;
    }

    @Override
    public boolean seek(T elemento) {
        return seekTree(raiz, elemento, false);
    }

    private boolean seekTree(NodoArvore<T> atual, T elemento, boolean encontrou) {
        if (atual != null && !encontrou) { // Corrigi a condição para verificar se não encontrou ainda
            encontrou = seekTree(atual.getNoEsquerdo(), elemento, encontrou);
            if (atual.getElemento().equals(elemento)) {
                encontrou = true;
            }
            encontrou = seekTree(atual.getNoDireito(), elemento, encontrou);
        }
        return encontrou;
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

    private void preOrdem(NodoArvore<T> atual){
        if (atual != null){
            System.out.println(atual.getElemento());
            preOrdem(atual.getNoEsquerdo());
            preOrdem(atual.getNoDireito());
        }
    }

    private void posOrdem(NodoArvore<T> atual){
        if (atual != null){
            posOrdem(atual.getNoEsquerdo());
            posOrdem(atual.getNoDireito());
            System.out.println(atual.getElemento());
        }
    }

}
