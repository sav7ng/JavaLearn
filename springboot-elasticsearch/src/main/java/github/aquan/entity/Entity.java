package github.aquan.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Class Entity
 * @Description TODO
 * @Author Aquan
 * @Date 2019.4.17 17:44
 * @Version 1.0
 **/
@ApiModel(description="城市")
public class Entity implements Serializable {

    private static final long serialVersionUID = -763638353551774166L;

    public static final String INDEX_NAME = "index_entity";

    public static final String TYPE = "tstype";

    @ApiModelProperty(value = "城市ID")
    private Long id;

    @ApiModelProperty(value = "城市名称")
    private String name;

    public Entity() {
        super();
    }

    public Entity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
