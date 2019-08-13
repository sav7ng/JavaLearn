package com.company.project.service.impl;

import com.company.project.model.IUser;
import com.company.project.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Class IUserServiceImpl
 * @Description TODO
 * @Author Aquan
 * @Date 2019.8.13 1:07
 * @Version 1.0
 **/
@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    @Override
    public boolean checkUser(String loginName, String password) {
        return true;
    }

    @Override
    public IUser getUserByLoginName(String loginName) {
        IUser user = new IUser();
        user.setId("2019");
        user.setName("joe");
        user.setAge(18);
        return user;
    }
}