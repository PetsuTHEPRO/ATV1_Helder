package Estruturas;

import Util.EstruturaDeDados;

import java.util.EmptyStackException;
import java.util.List;

class NodoSimples<T>{

    private T elemento;
    private NodoSimples<T> proximo;

    public NodoSimples(){
        this.elemento = null;
        this.proximo = null;
    }
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoSimples<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoSimples<T> proximo) {
        this.proximo = proximo;
    }

}
public class Stack<T> implements EstruturaDeDados<T> {

    private NodoSimples<T> top;
    private int tamanho;

    public Stack(List<T> dados){
        this.top = null;
        this.criarEstrutura(dados);
    }

    @Override
    public void criarEstrutura(List<T> dados) {
        for(T dado : dados){
            push(dado);
        }
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void add(T elemento) {
        push(elemento);
    }

    public void push(T elemento) {
        NodoSimples<T> novoNodo = new NodoSimples<>();
        novoNodo.setElemento(elemento);

        if (!isEmpty()) {
            novoNodo.setProximo(top);
        }
        top = novoNodo;
        this.tamanho++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T elementoRemovido = top.getElemento();
        top = top.getProximo();
        this.tamanho--;

        return elementoRemovido;
    }

    public T remove(T elemento) {
        return pop();
    }

    public boolean seek(T elemento) {
        NodoSimples<T> nodoAtual = top;

        while (nodoAtual != null) {
            T elementoAtual = nodoAtual.getElemento();
            if (elementoAtual.equals(elemento)) {
                return true;
            }
            nodoAtual = nodoAtual.getProximo();
        }

        return false;
    }

    public StringBuilder print(){

        StringBuilder sb = new StringBuilder();
        NodoSimples<T> nodoAtual = top;

        sb.append("[");
        while (nodoAtual != null) {
            sb.append(nodoAtual.getElemento()).append(" ");
            nodoAtual = nodoAtual.getProximo();
        }
        sb.append("]");

        return sb;
    }

}
