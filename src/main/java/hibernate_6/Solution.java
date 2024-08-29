package hibernate_6;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Sergei Aleshchenko
 */
public class Solution {
    public static void main(String[] args) {
        Book book = new Book("Core Java",
                "Learn Core Java with Coding Examples", ZonedDateTime.now());

        Book book1 = new Book("Learn Hibernate",
                "Learn Hibernate with building projects", ZonedDateTime.now());

        Book book2 = new Book("Learn Hibernate",
                "Learn Hibernate with building projects", ZonedDateTime.now());

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the book objects
            session.persist(book);
            session.persist(book1);
            session.persist(book2);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Book> books = session.createQuery("from Book", Book.class).list();
            books.forEach(b -> {
                System.out.println("Print book name : " + b.getName());
            });


            System.out.println("----------------------------------------");
            Book book3 = session.get(Book.class, 1);
            System.out.println(book3.getName() + " - " + book3.getDescription());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
