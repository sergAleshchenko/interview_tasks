package hibernate_4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * @author Sergei Aleshchenko
 */
public class HibernateMain {

    public static void main(String[] args) {
        Employee1 emp = new Employee1();
        emp.setName("Lisa");
        emp.setRole("Manager");
        emp.setInsertTime(new Date());

        //Get Session
        SessionFactory sessionFactory = HibernateUtil.getSessionJavaConfigFactory();
        Session session = sessionFactory.getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+emp.getId());

        //terminate session factory, otherwise program won't end
        sessionFactory.close();
    }
}
