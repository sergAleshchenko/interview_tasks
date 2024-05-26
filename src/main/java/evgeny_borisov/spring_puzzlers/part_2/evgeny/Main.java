package evgeny_borisov.spring_puzzlers.part_2.evgeny;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        context.getBean(СуперДуперУтюг.class).разогреваться();
        context.getBean(Паяльник.class).греться();
    }
}
