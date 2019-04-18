package github.aquan.controller;

import github.aquan.entity.Entity;
import github.aquan.service.TestService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class EntityController
 * @Description TODO
 * @Author Aquan
 * @Date 2019.4.17 17:44
 * @Version 1.0
 **/
@RestController
@RequestMapping("/entityController")
public class EntityController {

    @Autowired
    TestService cityESService;

    @RequestMapping(value="/save", method=RequestMethod.GET)
    public String save(long id, String name) {
        System.out.println("save_Api");
        if(id>0 && StringUtils.isNotEmpty(name)) {
            Entity newEntity = new Entity(id, name);
            List<Entity> addList = new ArrayList<Entity>();
            addList.add(newEntity);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "Bad input value";
        }
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public List<Entity> save(String name) {
        List<Entity> entityList = null;
        if(StringUtils.isNotEmpty(name)) {
            entityList = cityESService.searchEntity(name);
        }
        return entityList;
    }

}
