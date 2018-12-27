package cn.eunji.aquan.springbootmybatis.servicer;

import cn.eunji.aquan.springbootmybatis.dao.AccountMapper;
import cn.eunji.aquan.springbootmybatis.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Class AccountServicer
 * @Description TODO
 * @Author Aquan
 * @Date 2018.12.27 11:23
 * @Version 1.0
 **/
@Service
public class AccountServicer {
    @Autowired
    private AccountMapper accountMapper;

    public int add(String name, double money) {
        return accountMapper.add(name, money);
    }

    public int update(String name, double money, int id) {
        return accountMapper.update(name, money, id);
    }

    public int delete(int id) {
        return accountMapper.delete(id);
    }

    public Account findAccount(int id) {
        return accountMapper.findAccount(id);
    }

    public List<Account> findAccountList() {
        return accountMapper.findAccountList();
    }

}
