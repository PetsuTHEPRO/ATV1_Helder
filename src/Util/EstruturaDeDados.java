package util;

import java.util.List;

public interface DataStructure<T> {

    void createStructure(List<T> data);
    void add(T element);
    T remove(T element);
    boolean contains(T element);
    T get(T element);
    StringBuilder print();
}
