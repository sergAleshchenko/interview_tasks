package patterns.iterator.spammer;

import org.aspectj.org.eclipse.jdt.internal.core.util.CodeSnippetParsingUtil;
import patterns.iterator.iterators.ProfileIterator;
import patterns.iterator.profile.Profile;
import patterns.iterator.social_networks.SocialNetwork;

/**
 * @author Sergei Aleshchenko
 */
public class SocialSpammer {
    public SocialNetwork network;
    public ProfileIterator iterator;

    public SocialSpammer(SocialNetwork network) {
        this.network = network;
    }

    public void sendSpamToFriends(String profileEmail, String message) {
        System.out.println("\nIterating over friends...\n");
        iterator = network.createFriendsIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    public void sendSpamToCoworkers(String profileEmail, String message) {
        System.out.println("\nIterating over coworkers...\n");
        iterator = network.createCoworkersIterator(profileEmail);
        while (iterator.hasNext()) {
            Profile profile = iterator.getNext();
            sendMessage(profile.getEmail(), message);
        }
    }

    private void sendMessage(String email, String message) {
        System.out.println("Sent message to: '" + email +
                "'. Message body: '" + message + "'");

    }
}
