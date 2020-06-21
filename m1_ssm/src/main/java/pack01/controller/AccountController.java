package pack01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pack01.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;//注解可以取spring里面的对象

    @RequestMapping(path = "/zhuanzhang")
    public String zhuanzhang(Long from ,Long to,Double vale){
        //1:获取service
        //AccountService accountService = (AccountService) new ClassPathXmlApplicationContext("spring.xml").getBean("service");
        //2:转账 ：测试事务是否可以使用的小技巧
        try {
            accountService.translate(from,to,vale);
            return "success";
        } catch (Exception exception) {
            exception.printStackTrace();
            return "error";
        }

    }

}
