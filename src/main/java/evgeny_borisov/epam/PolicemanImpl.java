package evgeny_borisov.epam;

import javax.annotation.PostConstruct;

/**
 * @author Sergei Aleshchenko
 */
public class PolicemanImpl implements Policeman {

    @InjectByType
    private Recommendator recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("пиф паф, бах бах, кыш кыш");
    }
}
