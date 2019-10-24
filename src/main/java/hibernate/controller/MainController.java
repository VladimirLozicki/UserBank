package hibernate.controller;

import hibernate.model.Account;
import hibernate.service.Service;
import hibernate.service.ServiceUser;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static hibernate.util.HibernateSessionFactoryUtil.getSessionFactory;

@Controller
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class MainController {

    private static final String index = "/index";
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

    @GetMapping(value = "/")
    public String galaxyPage() {
        return index;
    }

    @Transactional
    @PostMapping(value = "/rich")
    public String rich(ModelMap modelMap) {
        int maxId = service.find(getMaxAccount()).getUserId();
        modelMap.addAttribute("name", serviceUser.find(maxId).getName());
        return index;
    }

    @Transactional
    @PostMapping(value = "/all")
    public String all(ModelMap modelMap) {
        modelMap.addAttribute("all", findAllAccount());
        return index;
    }

    private int getMaxAccount() {
        Session session = getSessionFactory().openSession();
        int id = (Integer) session
                .getSessionFactory()
                .openSession()
                .createSQLQuery("select accountid from account where account=(select MAX(account.account) from account)")
                .uniqueResult();
        session.close();
        return id;
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
}
