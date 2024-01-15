package patterns.iterator.iterators;

import patterns.iterator.profile.Profile;

/**
 * @author Sergei Aleshchenko
 */
public interface ProfileIterator {
    boolean hasNext();

    Profile getNext();

    void reset();
}
