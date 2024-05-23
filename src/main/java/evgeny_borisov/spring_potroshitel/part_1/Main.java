package evgeny_borisov.spring_potroshitel.part_1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        context.getBean(Quoter.class).sayQuote();
    }
}
