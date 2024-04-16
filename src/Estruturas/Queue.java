package Estruturas;

import Util.EstruturaDeDados;

import java.util.List;
import java.util.NoSuchElementException;

class Nodo<T>{

    private T elemento;
    private Nodo<T> proximo;

    public Nodo(){
        this.elemento = null;
        this.proximo = null;
    }
    public T getElemento() {
        return elemento;

