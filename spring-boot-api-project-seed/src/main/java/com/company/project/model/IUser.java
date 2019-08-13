package com.company.project.model;

/**
 * @Class IUser
 * @Description TODO
 * @Author Aquan
 * @Date 2019.8.13 1:06
 * @Version 1.0
 **/

public class IUser {

    private String id;

    private String name;

    private Integer age;

    public IUser() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}