package hibernate.model;

import hibernate.service.ServiceUser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;
import hibernate.service.Service;

import java.util.List;

import static hibernate.util.HibernateSessionFactoryUtil.getSessionFactory;
import static org.testng.Assert.assertEquals;

@ContextConfiguration(locations = {"classpath:beans.xml"})
public class UsersTest extends AbstractTestNGSpringContextTests {

    private Service service;
    private ServiceUser serviceUser;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @Autowired
    public void setServiceUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }

    @Test
    public void findIdUser() {
        assertEquals(serviceUser.find(5).getUserId(), 5);
    }

    @Test
    public void findIdAccount() {
        assertEquals(service.find(10).getAccountId(), 10);
    }

    @Test
    public void testFindAllAccounts() {
        assertEquals(service.findAllUsers().size(), 10);
    }

    @Test
    public void testFindAllUsers() {
        assertEquals(serviceUser.findAllUsers().size(), 10);
    }

    @Test
    public void testGetMaxAccount() {
        assertEquals(service.find(getMaxAccount()).getAccountId(), 10);
    }

    @Test
    public void testGetMaxUsers() {
        int userId = service.find(getMaxAccount()).getUserId();
        assertEquals(serviceUser.find(userId).getName(), "matvei");
    }

    @Test
    public void testSumAllAccount() {
        assertEquals(findAllAccount(), 5500);
    }

    private int findAllAccount() {
        int sum = 0;
        List<Account> list;
        list = service.findAllUsers();
        for (Account account : list) {
            sum = sum + account.getAccount();
        }
        return sum;
    }

    private int getMaxAccount() {
        Session session = getSessionFactory().openSession();
        int id = (Integer) session
                .getSessionFactory()
                .openSession()
                .createSQLQuery("select accountid from account where account" +
                        "=(select MAX(account.account) from account)")
                .uniqueResult();
        session.close();
        return id;
    }

}