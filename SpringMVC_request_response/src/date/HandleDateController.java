package date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import vo.User;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/date")
public class HandleDateController {

    //从前台--->后台传递参数：String--->java.util.Date
    //把请求封装成Date类型
    @RequestMapping("/test1")
    public ModelAndView test1( @DateTimeFormat(pattern = "yyyy-MM-dd") Date d ){
        System.out.println(d);
        return null;
    }

    @RequestMapping("/test2")
    public ModelAndView test2( User user){
        System.out.println(user);
        return null;
    }

    @ResponseBody
    @RequestMapping("/test3")
    public User test3(){
        User u = new User();
        u.setUsername("tom");
        u.setAge(10);
        u.setHiredate(new Date());
        return u;
    }

}
