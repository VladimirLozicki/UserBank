package hibernate.dao;

import hibernate.model.Account;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;

import java.util.List;

import static hibernate.util.HibernateSessionFactoryUtil.getSessionFactory;

public class DaoAccount {

    @Transactional
    public Account findById(int id) {
        Session session = getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Account account = session.get(Account.class, id);
        transaction.commit();
        session.close();
        return account;
    }

    public List<Account> findAll() {
        Session session = getSessionFactory().openSession();
        List<Account> list = session.createCriteria(Account.class).list();
        return list;
    }
}
