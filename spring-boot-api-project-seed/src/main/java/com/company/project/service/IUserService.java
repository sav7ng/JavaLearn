package com.company.project.service;


import com.company.project.model.IUser;
import org.springframework.stereotype.Service;

public interface IUserService {
    boolean checkUser(String loginName, String password);

    IUser getUserByLoginName(String loginName);
}
