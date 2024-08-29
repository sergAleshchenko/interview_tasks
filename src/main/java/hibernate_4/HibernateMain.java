package hibernate_4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
public class HibernateMain {

    public static void main(String[] args) {
        Employee1 emp = new Employee1();
        emp.setName("Lisa3");
        emp.setRole("Manager3");
        emp.setInsertTime(new Date());

        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();


        Transaction transaction = session.getTransaction();

        try {


            transaction.begin();
            session.persist(emp);

            Employee1 employee1 = session.get(Employee1.class, 1);
            transaction.commit();


            System.out.println("--------------------------------------------");
            System.out.println(employee1);
            System.out.println("--------------------------------------------");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error!");
            transaction.rollback();
        } finally {
            session.close();
        }

    }
}
