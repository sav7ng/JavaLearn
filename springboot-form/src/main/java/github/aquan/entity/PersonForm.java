package github.aquan.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @Class PersonForm
 * @Description TODO
 * @Author Aquan
 * @Date 2019.3.17 23:17
 * @Version 1.0
 **/

public class PersonForm {

    @NotNull
    @Size(min=2, max=30)
    private String name;


    @NotNull
    @Min(18)
    private Integer age;

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

    @Override
    public String toString() {
        return "PersonFormbu{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}