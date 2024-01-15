package patterns.iterator.social_networks;

import patterns.iterator.iterators.FacebookIterator;
import patterns.iterator.iterators.ProfileIterator;
import patterns.iterator.profile.Profile;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class Facebook implements SocialNetwork{
    private List<Profile> profiles;


    public Facebook(List<Profile> cache) {
        if (cache != null) {
            this.profiles = cache;
        } else {
            this.profiles = new ArrayList<>();
        }
    }

    public Profile requestProfileFromFacebook(String profileEmail) {
        simulateNetworkLatency();

        System.out.println("Facebook: Loading profile '" + profileEmail +
                "' over the network...");

        return findProfile(profileEmail);
    }

    public List<String> requestProfileFriendsFromFacebook(
            String profileEmail, String contactType) {

        simulateNetworkLatency();
        System.out.println("Facebook: Loading '" +
                contactType + "' list of '" + profileEmail +
                "; over the network...");

        Profile profile = findProfile(profileEmail);
        if (profile != null) {
            return profile.getContacts(contactType);
        }
        return null;
    }

    private Profile findProfile(String profileEmail) {
        for (Profile profile : profiles) {
            if (profile.getEmail().equals(profileEmail)) {
                return profile;
            }
        }
        return null;
    }

    private void simulateNetworkLatency() {
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FacebookIterator(this, "friends", profileEmail);
    }

    @Override
    public ProfileIterator createCoworkersIterator(String profileEmail) {
        return new FacebookIterator(this, "coworkers", profileEmail);
    }
}
