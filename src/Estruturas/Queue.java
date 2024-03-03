package Estruturas;

import java.util.List;

public class Queue<T> implements EstruturaDeDados<T>{

    private Nodo<T> end;
    private Nodo<T> start;
    private int tamanho;

    public Queue(List<T> dados){
        this.tamanho = 0;
        this.end = null;
        this.start = null;
        criarEstrutura(dados);
    }

    @Override
    public void criarEstrutura(List<T> dados) {
        for(T dado : dados){
            enqueue(dado);
        }
    }
    public int tamanho(){
        return this.tamanho;
    }
    public boolean isEmpty(){
        return (this.start == null);
    }

    public void add(T elemento){
        enqueue(elemento);
    }
    public void enqueue(T elemento) {

        Nodo<T> newNodo = new Nodo<>();
        newNodo.setElemento(elemento);

        if (this.end == null){
            this.start = newNodo;
        }else{
            this.end.setProximo(newNodo);
        }

        this.end = newNodo;
        this.tamanho++;

    }

    public T dequeue(){

        if(isEmpty()){
            return null;
        }

        T itemRemovido = start.getElemento();
        this.start = start.getProximo();

        return itemRemovido;
    }

    public T remove(T elemento) {

        T elementoRemovido = null;

        if (!isEmpty()) {
            if (start.getElemento().equals(elemento)) {
                return dequeue();
            }

            Nodo<T> nodoAtual = start;
            while (nodoAtual.getProximo() != null) {
                if (nodoAtual.getProximo().getElemento().equals(elemento)) {
                    elementoRemovido = nodoAtual.getProximo().getElemento();
                    nodoAtual.setProximo(nodoAtual.getProximo().getProximo());
                    break;
                }

                nodoAtual = nodoAtual.getProximo();
            }
        }

        return elementoRemovido;
    }

    public boolean seek(T elemento) {

        Nodo<T> nodoAtual = start;
        boolean encontrou = false;

        if (!isEmpty()) {

            while (nodoAtual != null) {

                T elementoAtual = nodoAtual.getElemento();
                encontrou = elementoAtual.equals(elemento);

                if(encontrou){
                    break;
                }

                nodoAtual = nodoAtual.getProximo();
            }

        }

        return encontrou;
    }

    public StringBuilder print(){

        StringBuilder sb = new StringBuilder();
        Nodo<T> nodoAtual = start;

        sb.append("[");
        while (nodoAtual != null) {
            sb.append(nodoAtual.getElemento() + " ");
            nodoAtual = nodoAtual.getProximo();
        }
        sb.append("]");

        return sb;
    }

}