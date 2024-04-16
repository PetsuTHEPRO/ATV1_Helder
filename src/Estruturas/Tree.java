package Estruturas;

import Util.EstruturaDeDados;
import java.util.List;

class NodoArvore<T extends Comparable<T>> {

    private T elemento;
    private NodoArvore<T> noEsquerdo;
    private NodoArvore<T> noDireito;

    public NodoArvore(T elemento) {
        this.elemento = elemento;
        noEsquerdo = null;
        noDireito = null;
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

    public Tree(List<T> dados) {
        raiz = null;
        criarEstrutura(dados);
    }

    public void add(T elemento) {
        NodoArvore<T> noAtual = new NodoArvore<>(elemento);

        if (raiz == null) {
            raiz = noAtual;
        } else {
            NodoArvore<T> atual = raiz;
            NodoArvore<T> paiAtual = null;

            while (true) {
                int comparacao = elemento.compareTo(atual.getElemento());
                if (comparacao < 0) {
                    paiAtual = atual;
                    atual = atual.getNoEsquerdo();
                    if (atual == null) {
                        paiAtual.setNoEsquerdo(noAtual);
                        break;
                    }
                } else {
                    paiAtual = atual;
                    atual = atual.getNoDireito();
                    if (atual == null) {
                        paiAtual.setNoDireito(noAtual);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public void criarEstrutura(List<T> dados) {
        for (T dado : dados) {
            add(dado);
        }
    }

    @Override
    public T remove(T elemento) {
        NodoArvore<T> atual = raiz;
        NodoArvore<T> paiAtual = null;

        while (atual != null) {
            int comparacao = elemento.compareTo(atual.getElemento());
            if (comparacao == 0) {
                break;
            } else if (comparacao < 0) {
                paiAtual = atual;
                atual = atual.getNoEsquerdo();
            } else {
                paiAtual = atual;
                atual = atual.getNoDireito();
            }
        }

        if (atual == null) {
            return null;
        }

        if (atual.getNoEsquerdo() == null && atual.getNoDireito() == null) {
            if (paiAtual == null) {
                raiz = null;
            } else if (paiAtual.getNoEsquerdo() == atual) {
                paiAtual.setNoEsquerdo(null);
            } else {
                paiAtual.setNoDireito(null);
            }
        } else if (atual.getNoEsquerdo() == null) {
            if (paiAtual == null) {
                raiz = atual.getNoDireito();
            } else if (paiAtual.getNoEsquerdo() == atual) {
                paiAtual.setNoEsquerdo(atual.getNoDireito());
            } else {
                paiAtual.setNoDireito(atual.getNoDireito());
            }
        } else if (atual.getNoDireito() == null) {
            if (paiAtual == null) {
                raiz = atual.getNoEsquerdo();
            } else if (paiAtual.getNoEsquerdo() == atual) {
                paiAtual.setNoEsquerdo(atual.getNoEsquerdo());
            } else {
                paiAtual.setNoDireito(atual.getNoEsquerdo());
            }
        } else {
            T sucessor = encontrarSucessor(atual);
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
