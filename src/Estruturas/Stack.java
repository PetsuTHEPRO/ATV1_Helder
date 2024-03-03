package Estruturas;

import java.util.EmptyStackException;
import java.util.List;

public class Stack<T> implements EstruturaDeDados<T>{

    private Nodo<T> top;
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
        Nodo<T> novoNodo = new Nodo<>();
        novoNodo.setElemento(elemento);

        if (!isEmpty()) {
            novoNodo.setProximo(top);
            top.setAnterior(novoNodo);
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

        if (top != null) {
            top.setAnterior(null);
        }

        return elementoRemovido;
    }

    public T remove(T elemento) {
        return null;
    }

    public boolean seek(T elemento) {
        Nodo<T> nodoAtual = top;

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
        Nodo<T> nodoAtual = top;

        sb.append("[");
        while (nodoAtual != null) {
            sb.append(nodoAtual.getElemento()).append(" ");
            nodoAtual = nodoAtual.getProximo();
        }
        sb.append("]");

        return sb;
    }

}
