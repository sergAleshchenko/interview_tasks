package evgeny_borisov.spring_puzzlers.part_2.evgeny;

import javax.annotation.PostConstruct;

/**
 * @author Sergei Aleshchenko
 */
public interface Утюг {

    @PostConstruct
    void разогреваться();

}
