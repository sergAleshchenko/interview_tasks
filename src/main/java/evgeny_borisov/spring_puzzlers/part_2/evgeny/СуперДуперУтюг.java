package evgeny_borisov.spring_puzzlers.part_2.evgeny;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Sergei Aleshchenko
 */
@Component
public class СуперДуперУтюг implements Утюг {

    @Override
    public void разогреваться() {
        System.out.println("разогреваюсь");
    }

    @Autowired
    public void гретьВоду(Вода вода) {
        System.out.println(вода + " грейся...");
    }
}
