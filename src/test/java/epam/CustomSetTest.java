package epam;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Sergei Aleshchenko
 */
class CustomSetTest {

    @Test
    void contains() {
        CustomSet customSet = new CustomSet(10);
        customSet.add(1);
        customSet.add(2);
        customSet.add(3);

        assertTrue(customSet.contains(1));
    }

    @Test
    void add() {
        CustomSet customSet = new CustomSet(2);
        customSet.add(1);
        customSet.add(2);
        customSet.add(3);

        assertTrue(customSet.contains(1));
        assertTrue(customSet.contains(2));
        assertTrue(customSet.contains(3));
        assertEquals(customSet.getCapacity(), 4);
    }

    @Test
    void remove() {
        CustomSet customSet = new CustomSet(2);
        customSet.add(1);
        customSet.add(2);
        customSet.add(3);

        customSet.remove(2);
        assertFalse(customSet.contains(2));
        assertEquals(customSet.getCapacity(), 4);
    }

    @Test
    void clear() {
        CustomSet customSet = new CustomSet(2);
        customSet.add(1);
        customSet.add(2);
        customSet.add(3);

        assertTrue(customSet.contains(1));
        assertTrue(customSet.contains(2));
        assertTrue(customSet.contains(3));

        customSet.clear();

        assertTrue(customSet.isEmpty());
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
    }
}