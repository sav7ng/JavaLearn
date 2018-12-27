package cn.eunji.aquan.springbootmybatis.dao;

import cn.eunji.aquan.springbootmybatis.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Class AccountMapper
 * @Description TODO
 * @Author Aquan
 * @Date 2018.12.27 11:01
 * @Version 1.0
 **/
@Mapper
public interface AccountMapper {

    @Insert("insert into account(name, money) values(#{name}, #{money})")
    int add(@Param("name") String name, @Param("money") double money);

    @Update("update account set name = #{name}, money = #{money} where id = #{id}")
    int update(@Param("name") String name, @Param("money") double money, @Param("id") int  id);

    @Delete("delete from account where id = #{id}")
    int delete(int id);

    @Select("select id, name as name, money as money from account where id = #{id}")
    Account findAccount(@Param("id") int id);

    @Select("select id, name as name, money as money from account")
    List<Account> findAccountList();

}
