package date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;

@ControllerAdvice
public class A {
    //如果不想每次都在Date类型上贴@DateTimeFormat
    @InitBinder
    public void initBinderDateType(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf, true));
    }
}
