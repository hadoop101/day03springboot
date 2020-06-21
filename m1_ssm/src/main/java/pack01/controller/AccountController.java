package pack01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pack01.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;//注解可以取spring里面的对象

    @RequestMapping(path = "/zhuanzhang")
    public ModelAndView zhuanzhang(Long from ,Long to,Double vale){
        //1:获取service
        //AccountService accountService = (AccountService) new ClassPathXmlApplicationContext("spring.xml").getBean("service");
        //2:转账 ：测试事务是否可以使用的小技巧
        ModelAndView modelAndView=new ModelAndView();
        try {
            accountService.translate(from,to,vale);
            modelAndView.addObject("msg","转账成功");
            modelAndView.setViewName("msg");
        } catch (Exception exception) {
            exception.printStackTrace();
            modelAndView.addObject("msg","转账失败");
            modelAndView.setViewName("msg");
        }
        return modelAndView;

    }

}
