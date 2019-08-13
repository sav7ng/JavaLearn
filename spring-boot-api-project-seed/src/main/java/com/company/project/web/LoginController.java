package com.company.project.web;

import com.company.project.enums.ApiResponseEnum;
import com.company.project.model.ApiResponse;
import com.company.project.model.IUser;
import com.company.project.service.IUserService;
import com.company.project.utils.ApiResponseUtil;
import com.company.project.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Class LoginController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.8.13 1:02
 * @Version 1.0
 **/
@RestController
@RequestMapping("/user")
public class LoginController {


    @Autowired
    private IUserService iUserService;

    /**
     * 登陆接口
     *
     * @return token
     */
    @PostMapping(value = "/login")
    public ApiResponse login(@RequestBody Map<String, String> map) {

        String loginName = map.get("loginName");
        String password = map.get("password");
        //身份验证是否成功
        boolean isSuccess = iUserService.checkUser(loginName, password);
        if (isSuccess) {
            IUser user = iUserService.getUserByLoginName(loginName);
            if (user != null) {
                //返回token
                String token = JwtUtil.sign(user.getName(), user.getId());
                if (token != null) {
                    return ApiResponseUtil.getApiResponse(token);
                }
            }
        }
        //返回登陆失败消息
        return ApiResponseUtil.getApiResponse(ApiResponseEnum.LOGIN_FAIL);
    }

}