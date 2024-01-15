package patterns.iterator.social_networks;

import patterns.iterator.iterators.ProfileIterator;

/**
 * @author Sergei Aleshchenko
 */
public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);

    ProfileIterator createCoworkersIterator(String profileEmail);
}
