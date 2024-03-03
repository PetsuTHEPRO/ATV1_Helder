package Estruturas;

class Nodo<T>{

    private T elemento;
    private Nodo<T> proximo;
    private Nodo<T> anterior;

    public Nodo(){
        this.elemento = null;
        this.proximo = null;
        this.anterior = null;
    }
    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getProximo() {
        return proximo;
    }

    public void setProximo(Nodo<T> proximo) {
        this.proximo = proximo;
    }

    public Nodo<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo<T> anterior) {
        this.anterior = anterior;
    }

}
