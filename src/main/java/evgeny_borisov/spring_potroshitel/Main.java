package evgeny_borisov.spring_potroshitel;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Sergei Aleshchenko
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("context.xml");


        context.getBean(TerminatorQuoter.class).sayQuote();
    }
}
