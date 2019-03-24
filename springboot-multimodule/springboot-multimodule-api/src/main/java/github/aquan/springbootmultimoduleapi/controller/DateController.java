package github.aquan.springbootmultimoduleapi.controller;

import github.aquan.springbootmultimoduleutils.helper.CommonMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Class DateController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.24 20:30
 * @Version 1.0
 **/

@RestController
@RequestMapping("/date")
public class DateController {


    @GetMapping("/now")
    public String getDate() {
        Date date = CommonMethod.getCurDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return "当前时间：" + simpleDateFormat.format(date);
    }

}