package Estruturas;

import java.util.List;

public class DoublyLinkedList<T> implements EstruturaDeDados<T>{

    private Nodo<T> head;
    private int tamanho;

    public DoublyLinkedList(List<T> dados){
        this.tamanho = 0;
        this.head = null;
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
        Nodo<T> newNodo = new Nodo<>();

        newNodo.setElemento(elemento);

        if (isEmpty()) {
            head = newNodo;
        } else {
            Nodo<T> nodoAtual = head;
            while (nodoAtual.getProximo() != null) {
                nodoAtual = nodoAtual.getProximo();
            }
            nodoAtual.setProximo(newNodo);
            newNodo.setAnterior(nodoAtual);
        }

        tamanho++;
    }

    public T remove(T elemento) {

        Nodo<T> nodoAtual = head;
        T elementoRemovido;

        if(isEmpty()){
            return null;
        }else{

            while(nodoAtual != null){

                if(nodoAtual.getElemento().equals(elemento)){

                    if(nodoAtual == head){
                        elementoRemovido = nodoAtual.getElemento();
                        head = nodoAtual.getProximo();
                        if(head != null){
                            nodoAtual.setAnterior(null);
                        }

                    }else {

                        elementoRemovido = nodoAtual.getElemento();
                        Nodo<T> anterior = nodoAtual.getAnterior();
                        Nodo<T> proximo = nodoAtual.getProximo();

                        if(anterior != null){
                            anterior.setProximo(proximo);
                        }

                        if(proximo != null){
                            proximo.setAnterior(anterior);
                        }

                    }

                    this.tamanho--;
                    return elementoRemovido;
                }
                nodoAtual = nodoAtual.getProximo();
            }
        }

        return null;
    }

    public boolean seek(T elemento) {

        Nodo<T> nodoAtual = head;

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
        Nodo<T> nodoAtual = head;

        sb.append("[ ");
        while (nodoAtual != null) {
            sb.append(nodoAtual.getElemento() + " ");
            nodoAtual = nodoAtual.getProximo();
        }
        sb.append("]");

        return sb;
    }

}

/*

typedef struct nodo *ptr_nodo;

struct nodo {
  elemento elem;
  ptr_nodo prox;
};

typedef struct {
  ptr_nodo lista;
  int tamanho;
} lista_encadeada;

typedef lista_encadeada tipo_lista;

int tamanho(lista_encadeada le) { return le.tamanho; }

int obter_elemento(lista_encadeada le, int i, elemento *e) {
    int j;
    ptr_nodo pnodo;
    if ((i <= le.tamanho) && (i > 0)) {
        pnodo = le.lista;
        for (j = 2; j <= i; j++)
            pnodo = pnodo->prox;
    *e = pnodo->elem;
        return 1;
    } else {
    *e = VL_NULO;
        return 0;
    }
}

void inicializa_lista(lista_encadeada *le) {
    le->tamanho = 0;
    le->lista = NULL;
}

int incluir_elemento(lista_encadeada *le, int i, elemento e) {
    int j;
    ptr_nodo pnodo_incluido, pnodo_anterior;
    if ((i <= le->tamanho + 1) && (i > 0)) {
        pnodo_incluido = (ptr_nodo)malloc(sizeof(struct nodo));
        if (pnodo_incluido == NULL)
            return 0;
        else {
            pnodo_incluido->elem = e;
            if (i == 1) {
                pnodo_incluido->prox = le->lista;
                le->lista = pnodo_incluido;
            } else {
                pnodo_anterior = le->lista;
                for (j = 2; j < i; j++)
                    pnodo_anterior = pnodo_anterior->prox;
                pnodo_incluido->prox = pnodo_anterior->prox;
                pnodo_anterior->prox = pnodo_incluido;
            }
            le->tamanho = le->tamanho + 1;
            return 1;
        }
    } else
        return 0;
}

int excluir_metade(tipo_lista *le) {
    ptr_nodo pnodo_excluido;
    int metade = tamanho(*le) / 2;
    for (int i = 1; i <= metade; i++) // faça x vezes
    {
        pnodo_excluido = le->lista;
        le->lista = le->lista->prox;
        le->tamanho--;
        free(pnodo_excluido);
    }
}

int alterar_elemento(lista_encadeada *le, int i, elemento e) {
    int j;
    ptr_nodo pnodo;
    if ((i <= le->tamanho) && (i > 0)) {
        pnodo = le->lista;
        for (j = 2; j <= i; j++)
            pnodo = pnodo->prox;
        pnodo->elem = e;
        return 1;
    } else
        return 0;
}

int excluir_elemento(lista_encadeada *le, int i) {
    int j;
    ptr_nodo pnodo_excluido, pnodo_anterior;
    if ((i <= le->tamanho) && (i > 0)) {
        if (i == 1) {
            pnodo_excluido = le->lista;
            le->lista = pnodo_excluido->prox;
        } else {
            pnodo_anterior = le->lista;
            for (j = 2; j < i; j++)
                pnodo_anterior = pnodo_anterior->prox;
            pnodo_excluido = pnodo_anterior->prox;
            pnodo_anterior->prox = pnodo_excluido->prox;
        }
        free(pnodo_excluido);
        le->tamanho = le->tamanho - 1;
        return 1;
    } else
        return 0;
}

* */
