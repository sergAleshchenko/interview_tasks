package evgeny_borisov.epam;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
//        CoronaDesinfector desinfector =
//                ObjectFactory.getInstance().createObject(CoronaDesinfector.class);

        ApplicationContext context = Application.run("evgeny_borisov.epam",
                new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDesinfector desinfector = context.getObject(CoronaDesinfector.class);
        desinfector.start(new Room());
    }
}
