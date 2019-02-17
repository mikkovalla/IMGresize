package datastructure;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Consumer;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test class for my own ArrayList implementation
 *
 * @author mikko
 */
public class MyArrayListTest {

    private final MyArrayList<String> tester = new MyArrayList<>();

    public MyArrayListTest() {
    }

    @Before
    public void setUp() {

        tester.add("eka");
        tester.add("toka");
        tester.add("kolmas");
        tester.add("neljas");
    }

    /**
     * Test of add method, of class MyArrayList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        MyArrayList instance = new MyArrayList();
        instance.add('q');
        tester.add("viides");

        int i = 0;
        Random r = new Random();
        while (i <= 101) {
            char c = (char) (r.nextInt(25) + 'a');
            instance.add(c);
            i++;
        }
        if (instance.size() <= 100) {
            fail("Instance size didn't increase");
        }
        if (tester.size() <= 4) {
            fail("Tester size didn't increase");
        }

    }

    /**
     * Test of get method, of class MyArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        String value = "eka";
        if (!value.equals(tester.get(0))) {
            fail("Getter returned wrong value!");
        }
    }

    /**
     * Test of iterator method, of class MyArrayList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        MyArrayList instance = new MyArrayList();

        int i = 0;
        Random r = new Random();
        while (i <= 10) {
            int num = (int) (r.nextInt(10));
            instance.add(num);
            i++;
        }
        instance.forEach(item -> {
            System.out.println(item);
        });
    }

}
