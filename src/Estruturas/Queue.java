package Estruturas;

import Util.EstruturaDeDados;

import java.util.List;

class Nodo<T>{

    private T elemento;
    private NodoSimples<T> proximo;

    public Nodo(){
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

public class Queue<T> implements EstruturaDeDados<T> {

    private NodoSimples<T> end;
    private NodoSimples<T> start;
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

        NodoSimples<T> newNodo = new NodoSimples<>();
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
        return dequeue();
    }

    public boolean seek(T elemento) {

        NodoSimples<T> nodoAtual = start;
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
        NodoSimples<T> nodoAtual = start;

        sb.append("[");
        while (nodoAtual != null) {
            sb.append(nodoAtual.getElemento() + " ");
            nodoAtual = nodoAtual.getProximo();
        }
        sb.append("]");

        return sb;
    }

}