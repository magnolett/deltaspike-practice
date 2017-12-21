package br.com.assertsistemas.practice.deltaspike.jpa;


public class BaseEvent< T extends BaseEntity > {
    private final T pojo;

    public BaseEvent( T pojo ) {
        this.pojo = pojo;
    }

    public T get() {
        return pojo;
    }
}
