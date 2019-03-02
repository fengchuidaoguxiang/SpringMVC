package json;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vo.User;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

//处理JSON
@Controller
@RequestMapping("/json")
public class HandleJsonController {
    /**
     * 处理json的注解：
     *     @ResponseBody：处理响应，把对象转换为json字符串。
     *        贴到方法上：只针对当前方法做json处理
     *        贴到类上： 会对当前类中所有的方法做json处理
     *
     *     @RestController: @Controller + @ResponseBody
     *
     *     @RequestBody：处理请求的，用于读取http请求的内容，把json格式的请求数据封装成对象。
     *
     *     一般的请求的数据格式：
     *       application/x-www-form-urlencoded: 传统的key-value格式，处理起来非常方便。不需要@RequestBody，贴上该注解也可以。
     *       application/multipart: 文件上传的请求，SpringMVC装上了装饰设计模式，即能处理文件上传，也能处理普通表单数据。
     *       application/json: 参数是json格式的数据，此时必须使用@RequestBody.
     *       application/xml:
     *
     */

    //把单个对象（包括Map对象）转换为json格式
    @ResponseBody
    @RequestMapping("/test1")
    public User test1(){
        User u = new User();
        u.setUsername("Tom");
        u.setAge(14);
        return u;
    }

    //把多个对象转换为json
    @ResponseBody
    @RequestMapping("/test2")
    public List<User> test2(){
        User u = new User();
        u.setUsername("Tom");
        u.setAge(19);
        return Arrays.asList(u,u,u);
    }

    //返回一个字符串,把返回的字符串不会当作是逻辑视图名称，而是当做json格式的数据。
    @ResponseBody
    @RequestMapping(value="/test3",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String test3(){
        return "success,你好";
    }


}
