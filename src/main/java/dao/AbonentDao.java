package dao;

import entity.Abonent;

import java.util.List;

public interface AbonentDao extends BaseDao <Long, Abonent> {

    List<Abonent> findAbonentByLastname(String patternName) throws DaoException;


}
