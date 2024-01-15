package others;

import dao.DaoException;
import dao.impl.AbonentDaoImpl;
import entity.Abonent;

import java.util.List;

public class TestDao {

    public static void main(String[] args) {
        AbonentDaoImpl abonentDao = new AbonentDaoImpl();
        List<Abonent> allAbonents = abonentDao.findAll();
        for (Abonent abonent : allAbonents) {
            System.out.println(abonent);
        }

        List<Abonent> kavalski = null;
        try {
            kavalski = abonentDao.findAbonentByLastname("Kavalski");
        } catch (DaoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(kavalski);
    }
}
