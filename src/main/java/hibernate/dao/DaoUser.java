package hibernate.dao;

import hibernate.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;

import java.util.List;

import static hibernate.util.HibernateSessionFactoryUtil.getSessionFactory;

public class DaoUser {

    @Transactional
    public Users findById(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Users users = session.get(Users.class, id);
        transaction.commit();
        session.close();
        return users;
    }

    public List<Users> findAll() {
        Session session = getSessionFactory().openSession();
        List<Users> list = session.createCriteria(Users.class).list();
        return list;
    }

}
