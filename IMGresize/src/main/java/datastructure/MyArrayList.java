package datastructure;

import java.util.Arrays;
import java.util.Iterator;

/**
 * This Class is my own implemetation/'try-to-copy' Java's ArrayList data
 * structure
 *
 * @author mikko
 * @param <Element> Type cast for object type
 */
public class MyArrayList<Element> implements Iterable<Element> {

    private int size = 0;
    private final int NumberOfItems = 100;
    private Object items[];

    /**
     * Constructor creates a new fixed sized array
     * 
     */
    public MyArrayList() {
        items = new Object[NumberOfItems];
    }

    /**
     * Add method to append an item to the array
     *
     * @param element Element object
     */
    public void add(Element element) {
        if (size == items.length) {
            increaseSize();
        }
        items[size++] = element;
    }

    /**
     * Generic method to increase the size of the array if the last index is met.
     */
    private void increaseSize() {
        int increasedSize = items.length * 2;
        items = Arrays.copyOf(items, increasedSize);
    }
    /**
     * Generic method to return Array size.
     * @return Array length
     */
    public int size() {
        return size;
    }
    

    /**
     * Get method to get the item at specific index of the list
     * @param index index of the desired item
     * @return The item at index if found
     */
    public Element get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + "is over the limit");
        }
        return (Element) items[index];
    }

    /**
     * Iterator class implementation with overrides to get enchanced for loop
     * working
     *
     */
    @Override
    public Iterator<Element> iterator() {
        Iterator<Element> iterator = new Iterator<Element>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Element next() {
                return (Element) items[index++];
            }

            @Override
            public void remove() {

            }
        };
        return iterator;
    }
}
