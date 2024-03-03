package Estruturas;

public class Stack<T>{

    private Nodo<T> top;
    private int tamanho;

    public void add(T elemento) {

        Nodo<T> newNodo = new Nodo<>();

        newNodo.setElemento(elemento);
        newNodo.setProximo(this.top);

        this.top = newNodo;
        this.tamanho++;
    }

    public void remove(T elemento) {

    }

    public boolean seek(T elemento) {
        return false;
    }

    public StringBuilder print(){

        StringBuilder sb = new StringBuilder();
        Nodo<T> nodoAtual = top;

        sb.append("[");
        while (nodoAtual != null) {
            sb.append(nodoAtual.getElemento() + " ");
            nodoAtual = nodoAtual.getProximo();
        }
        sb.append("]");

        return sb;
    }

}
