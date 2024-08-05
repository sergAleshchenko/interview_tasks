package evgeny_borisov.spring_puzzlers.part_2.evgeny;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

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
