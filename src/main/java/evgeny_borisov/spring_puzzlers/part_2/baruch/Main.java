package evgeny_borisov.spring_puzzlers.part_2.baruch;

import evgeny_borisov.spring_puzzlers.part_2.evgeny.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BaruchConfig.class, JekaConfig.class);
//        System.out.println(context.getBean(BaruchService.class).getList());
    }
}
