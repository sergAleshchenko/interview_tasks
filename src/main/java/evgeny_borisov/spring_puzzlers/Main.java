package evgeny_borisov.spring_puzzlers;

import evgeny_borisov.spring_potroshitel.part_1.Quoter;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//        context.getBean(JokerConfService.class).pay();
        context.getBean(JokerConfService.class).payTransactional();
    }
}
