package Stack_Queoe;

import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> elements;

    public GenericQueue() {
        elements = new LinkedList<>();
    }

    public void enqueue(E e) {
        elements.addLast(e);
    }

    public E dequeue() {
        return elements.removeFirst();
    }

    public int getSize() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.size() == 0;
    }

    public E poll() {
        E item = elements.peek();
        if (item == null)
            return null;
        elements.remove();
        return item;
    }
}
