package hibernate.service;

import hibernate.dao.DaoAccount;
import hibernate.dao.DaoUser;
import hibernate.model.Users;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


@ContextConfiguration("classpath:beans.xml")
public class ServiceUser {

    @Qualifier("daoUser")
    private DaoUser daoUser;

    public ServiceUser() {
    }

    public ServiceUser(DaoUser daoUser) {
        this.daoUser = daoUser;
    }

    public Users find(int id) {
        return daoUser.findById(id);
    }

    public List<Users> findAllUsers() {
        return daoUser.findAll();
    }
}
