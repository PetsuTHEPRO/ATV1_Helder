package Estruturas;

import Util.EstruturaDeDados;

import java.util.List;

class NodoDuplo<T>{

    private T elemento;
    private NodoDuplo<T> proximo;
    private NodoDuplo<T> anterior;

    public NodoDuplo(T elemento){
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NodoDuplo<T> getProximo() {
        return proximo;
    }

    public void setProximo(NodoDuplo<T> proximo) {
        this.proximo = proximo;
    }

    public NodoDuplo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDuplo<T> anterior) {
        this.anterior = anterior;
    }

}
public class DoublyLinkedList<T> implements EstruturaDeDados<T> {

    private NodoDuplo<T> head;
    private int tamanho;

    public DoublyLinkedList(){
        this.head = null;
        this.tamanho = 0;
    }

    public DoublyLinkedList(List<T> dados){
        this();
        criarEstrutura(dados);
    }

    public void criarEstrutura(List<T> dados){
        for(T dado : dados){
            this.add(dado);
        }
    }
    public int tamanho() {
        return this.tamanho;
    }
    public boolean isEmpty(){
        return (this.tamanho <= 0);
    }

    public void add(T elemento) {
        NodoDuplo<T> newNodo = new NodoDuplo<>(elemento);

        if (isEmpty()) {
            head = newNodo;
        } else {
            NodoDuplo<T> nodoAtual = head;
            while (nodoAtual.getProximo() != null) {
                nodoAtual = nodoAtual.getProximo();
            }
            nodoAtual.setProximo(newNodo);
            newNodo.setAnterior(nodoAtual);
        }

        tamanho++;
    }

    public T remove(T elemento) {

        NodoDuplo<T> nodoAtual = head;
        T elementoRemovido = null;

        if(isEmpty()){
            return null;
        }else{

            while(nodoAtual != null){

                if(nodoAtual.getElemento().equals(elemento)){

                    if(nodoAtual == head){
                        elementoRemovido = nodoAtual.getElemento();
                        head = nodoAtual.getProximo();
                        if(head != null){
                            nodoAtual.getProximo().setAnterior(null);
                        }

                    }else {

                        elementoRemovido = nodoAtual.getElemento();
                        NodoDuplo<T> anterior = nodoAtual.getAnterior();
                        NodoDuplo<T> proximo = nodoAtual.getProximo();

                        if(anterior != null){
                            anterior.setProximo(proximo);
                        }

                        if(proximo != null){
                            proximo.setAnterior(anterior);
                        }

                    }

                    this.tamanho--;
                    break;
                }
                nodoAtual = nodoAtual.getProximo();
            }
        }

        return elementoRemovido;
    }

    public boolean seek(T elemento) {

        NodoDuplo<T> nodoAtual = head;

        if (!isEmpty()) {
            while(nodoAtual != null){
                T elementoAtual = nodoAtual.getElemento();
                if(elementoAtual.equals(elemento)){
                    return true;
                }

                nodoAtual = nodoAtual.getProximo();
            }

        }

        return false;
    }

    public StringBuilder print(){

        StringBuilder sb = new StringBuilder();
        NodoDuplo<T> nodoAtual = head;

        sb.append("[ ");
        while (nodoAtual != null) {
            sb.append(nodoAtual.getElemento()).append(" ");
            nodoAtual = nodoAtual.getProximo();
        }
        sb.append("]");

        return sb;
    }

}
