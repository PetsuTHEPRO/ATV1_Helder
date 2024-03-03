package Estruturas;

public class NodoArvore<T> {

    private T elemento;
    private NodoArvore<T> noEsquerdo;
    private NodoArvore<T> noDireito;

    public void NodoArvore(){
        elemento = null;
        noDireito = null;
        noEsquerdo = null;
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
