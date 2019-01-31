package request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//操作其它的请求信息
@Controller
@RequestMapping("/other")
@SessionAttributes("errorMsg")
public class OtherController {

    @RequestMapping("/test1")
    public ModelAndView test1(@RequestHeader("User-Agent") String userAgent,@CookieValue("JSESSIONID") String cName){
        System.out.println("test1.....");
        System.out.println("User-Agent:" + userAgent);
        System.out.println("cName:" + cName);
        return null;
    }

    /**
     * 操作HttpSession,
     *  默认情况下Model数据是放到request中共享的，如果我想在session级别共享------->@SessionAttribute
     */
    @RequestMapping("/test2")
    public String test2(Model model){
        System.out.println("test2.....");
        model.addAttribute("errorMsg","错误信息");
        return "redirect:/abc.jsp";
    }

}
