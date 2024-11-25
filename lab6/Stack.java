package lab6;

import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class Stack<T> {
    private T[] data; 
    private int size;
     
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) { 
            if (size == data.length) {
                throw new StackOverflowError("Стек заполнен, невозможно добавить элемент");
            }
            data[size] = element;
            size++;
    }

    public T pop() {
        if (size == 0) { 
            throw new EmptyStackException();
        }
        T element = data[--size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }

    public int size() {
        return size;
    }
}
