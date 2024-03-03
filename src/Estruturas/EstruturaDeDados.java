package Estruturas;

import java.util.List;

public interface EstruturaDeDados<T> {

    void criarEstrutura(List<T> dados);
    void add(T elemento);
    T remove(T elemento);
    boolean seek(T elemento);
    StringBuilder print();
}
