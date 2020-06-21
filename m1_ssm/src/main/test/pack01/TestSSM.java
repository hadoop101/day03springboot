package pack01;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pack01.bean.Account;
import pack01.dao.AccountDao;
import pack01.util.MySessionUtil;

public class TestSSM {
    @Test
    public void test01SpringIOC(){
        //1:创建容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        //2:获取dao
        AccountDao accountDao = (AccountDao) applicationContext.getBean("dao");
        //3:调用
        Account account = accountDao.find(1001L);
        System.out.println(account);
    }

    @Test
    public void test02MyBatis(){
        //1:核心配置文件的数据
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) new ClassPathXmlApplicationContext("spring.xml").getBean("sqlSessionFactory");
        SqlSession session =sqlSessionFactory.openSession();
        //2:再考虑测试映射文件
        System.out.println(session);
        AccountDao accountDao = session.getMapper(AccountDao.class);
        //3:增删改查
        Account account = accountDao.find(1001L);
        System.out.println(account);
    }
}
