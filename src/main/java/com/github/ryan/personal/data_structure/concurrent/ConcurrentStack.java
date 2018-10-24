package com.github.ryan.personal.data_structure.concurrent;

import javax.annotation.concurrent.ThreadSafe;
import java.util.concurrent.atomic.AtomicReference;

/**
 * ConcurrentStack
 *
 * Nonblocking stack using Treiber's algorithm
 *
 */
@ThreadSafe
public class ConcurrentStack<E> {

    AtomicReference<Node<E>> top = new AtomicReference<>();

    public void push(E item) {
        Node<E> newHead = new Node<>(item);
        Node<E> oldHead;
        do {
            oldHead = top.get();
            newHead.next = oldHead;
        } while (!top.compareAndSet(oldHead, newHead));
    }

    public E pop() {
        Node<E> oldHead;
        Node<E> newHead;
        do {
            oldHead = top.get();
            if (oldHead == null) return null;

            newHead = oldHead.next;
        } while (!top.compareAndSet(oldHead, newHead));
        return oldHead.e;
    }

    private static class Node<E> {
        E e;
        Node<E> next;

        Node(E e) {
            this.e = e;
        }
    }

}
