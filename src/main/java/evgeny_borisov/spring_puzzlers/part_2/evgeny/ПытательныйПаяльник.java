package evgeny_borisov.spring_puzzlers.part_2.evgeny;

/**
 * @author Sergei Aleshchenko
 */
public class ПытательныйПаяльник implements Паяльник {

    @Override
    public void греться() {
        System.out.println("Разогреваюсь медленно...");
    }
}
