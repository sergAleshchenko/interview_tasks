package patterns.chain_of_responsibility.middleware;


import lombok.AllArgsConstructor;
import patterns.chain_of_responsibility.server.Server;

/**
 * @author Sergei Aleshchenko
 */
@AllArgsConstructor
public class UserExistsMiddleware extends Middleware {
    private Server server;

    @Override
    public boolean check(String email, String password) {
        if (!server.hasEmail(email)) {
            System.out.println("This email is not registered!");
            return false;
        }

        if (!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
            return false;
        }

        return checkNext(email, password);
    }
}
