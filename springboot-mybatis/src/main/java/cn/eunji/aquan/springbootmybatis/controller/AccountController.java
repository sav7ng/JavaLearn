package cn.eunji.aquan.springbootmybatis.controller;

import cn.eunji.aquan.springbootmybatis.entity.Account;
import cn.eunji.aquan.springbootmybatis.servicer.AccountServicer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Class AccountController
 * @Description TODO
 * @Author Aquan
 * @Date 2018.12.27 13:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountServicer accountServicer;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Account> getAccounts() {
        return accountServicer.findAccountList();
    }

    /**
     * @PathVariable 可以映射URL中 的占位符到目标方法中的参数中
     * @param id
     * @return cn.eunji.aquan.springbootmybatis.entity.Account
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Account getAccountById(@PathVariable("id") int id) {
        return accountServicer.findAccount(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String updateAccount(@PathVariable("id") int id,
                                @RequestParam(value = "name", required = true) String name,
                                @RequestParam(value = "money", required = true) double money) {
        int t = accountServicer.update(name, money, id);
        if(t==1) {
            return  "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String  delete(@PathVariable(value = "id") int id) {
        int t = accountServicer.delete(id);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postAccount(@RequestParam(value = "name") String name,
                              @RequestParam(value = "money") double money) {
        int t =  accountServicer.add(name, money);
        if(t==1) {
            return "success";
        }else {
            return "fail";
        }
    }

}
