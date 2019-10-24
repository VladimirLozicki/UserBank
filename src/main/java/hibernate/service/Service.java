package hibernate.service;

import hibernate.dao.DaoAccount;
import hibernate.model.Account;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration("classpath:beans.xml")
public class Service {

    @Qualifier("daoAccount")
    private DaoAccount daoAccount;

    public Service() {

    }

    public Service(DaoAccount daoAccount) {
        this.daoAccount = daoAccount;
    }

    public Account find(int id) {
        return daoAccount.findById(id);
    }

    public List<Account> findAllUsers() {
        return daoAccount.findAll();
    }
}
