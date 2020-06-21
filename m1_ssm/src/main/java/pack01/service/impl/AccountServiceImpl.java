package pack01.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack01.bean.Account;
import pack01.dao.AccountDao;
import pack01.service.AccountService;
//Controller  @Controller
//Service   @Service
//Dao   @Repository

@Service("service")//将对象交给spring管理，并指定id值为service
public class AccountServiceImpl implements AccountService {
    //调dao
    @Autowired //从spring容器中查找符合类型的dao对象
    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void translate(long from, long to, double value) {
        Account a1 = accountDao.find(from);
        Account a2 = accountDao.find(to);
        a1.setMoney(a1.getMoney()-value);
        a2.setMoney(a2.getMoney()+value);
        accountDao.update(a1);
        //System.out.println(1/0);
        accountDao.update(a2);
    }
}
