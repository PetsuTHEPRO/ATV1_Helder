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

/*
typedef struct nodo *ptrNodo;
struct nodo {
    elemento elem;
    ptrNodo prox;
      };

typedef struct {
    ptrNodo inicio;
                ptrNodo fim;
    int tamanho;
         } fila;

typedef fila tipo_fila;

int tamanho(fila f) {
   return f.tamanho;
}

void criarFila(fila *f) {
  f->tamanho = 0;
  f->inicio  = NULL;
  f->fim     = NULL;
}

int filaVazia(fila f) {
     return (f.inicio==NULL);
}

int filaCheia(fila f) {
	ptrNodo pnodo;
    pnodo = (ptrNodo) malloc(sizeof(struct nodo));
  if (pnodo == NULL)
     return 1;
  else {
           free(pnodo);
           return 0;
        }
   return 0;
           }

int primeiroFila(fila f, elemento *e) {
    if (!filaVazia(f)) {
      *e = (f.inicio)->elem;
        return 1;
    }
    else
        return 0;
}

int entrarElemento(fila *f, elemento e) {
    ptrNodo pnodo;
    pnodo = (ptrNodo) malloc(sizeof(struct nodo));
    if (pnodo == NULL)
        return 0;
    else {
        pnodo->elem = e;
        pnodo->prox = NULL;

        if (f->fim != NULL)
            f->fim->prox = pnodo;
        f->fim = pnodo;

        if (f->inicio == NULL)
            f->inicio = pnodo;
        f->tamanho++;
        return 1;
    }
}

int sairElemento(fila *f, elemento *e) {
    ptrNodo pnodo;
    if (filaVazia(*f))
    return 0;
  else {
        pnodo = f->inicio;
        f->inicio = f->inicio->prox;
    *e = pnodo->elem;
        free(pnodo);
        if (f->inicio == NULL)
            f->fim = NULL;
        f->tamanho--;
        return 1;
    }
}
* */