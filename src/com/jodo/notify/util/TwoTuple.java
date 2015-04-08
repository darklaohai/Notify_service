package com.jodo.notify.util;

/**
 * @author chenjian
 */
public class TwoTuple<A, B> {
    private final A first;

    private final B second;

    public TwoTuple(A a, B b) {
        first = a;
        second = b;
    }

    /**
     * @return the first
     */
    public A getFirst() {
        return first;
    }

    /**
     * @return the second
     */
    public B getSecond() {
        return second;
    }
}
