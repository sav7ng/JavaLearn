package github.aquan.controller;

import github.aquan.entity.Entity;
import github.aquan.service.TestService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value="保存City", notes="saveCity")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="城市ID", required=true, dataType="Long"),
            @ApiImplicitParam(name="cityName", value="城市名称", required=true, dataType="String")})
    public String save(long id, String cityName) {
        System.out.println("save_Api");
        if(id>0 && StringUtils.isNotEmpty(cityName)) {
            Entity newEntity = new Entity(id, cityName);
            List<Entity> addList = new ArrayList<Entity>();
            addList.add(newEntity);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "Bad input value";
        }
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    @ApiOperation(value="查询City", notes="searchCity")
    @ApiImplicitParam(name="cityName", value="城市名称", required = true, dataType = "String")
    public List<Entity> search(String cityName) {
        List<Entity> entityList = null;
        if(StringUtils.isNotEmpty(cityName)) {
            entityList = cityESService.searchEntity(cityName);
        }
        return entityList;
    }

    @GetMapping("/savev2")
    @ApiOperation(value="保存City", notes="saveCity")
    // @ApiImplicitParams({
    //         @ApiImplicitParam(name="id", value="城市ID", required=true, dataType="Long"),
    //         @ApiImplicitParam(name="cityName", value="城市名称", required=true, dataType="String")})
    public String savev2(@RequestParam(value="id", required=true) long id,
                         @RequestParam(value="cityName", required=true) String cityName) {
        System.out.println("save_Api");
        if(id>0 && StringUtils.isNotEmpty(cityName)) {
            Entity newEntity = new Entity(id, cityName);
            List<Entity> addList = new ArrayList<Entity>();
            addList.add(newEntity);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "Bad input value";
        }
    }

    @GetMapping("/searchv2")
    @ApiOperation(value="查询City", notes="searchCity")
    // @ApiImplicitParam(name="cityName", value="城市名称", required = true, dataType = "String")
    public List<Entity> searchv2(@RequestParam(value="cityName", required=true) String cityName) {
        List<Entity> entityList = null;
        if(StringUtils.isNotEmpty(cityName)) {
            entityList = cityESService.searchEntity(cityName);
        }
        return entityList;
    }

    @GetMapping("/savev3")
    @ApiOperation(value="保存City", notes="saveCity")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value="城市ID", required=true, dataType="Long"),
            @ApiImplicitParam(name="city", value="城市名称", required=true, dataType="String")})
    public String savev3(@RequestParam(value="id", required=true) long id,
                         @RequestParam(value="city", required=true) String cityName) {
        System.out.println("save_Api");
        if(id>0 && StringUtils.isNotEmpty(cityName)) {
            Entity newEntity = new Entity(id, cityName);
            List<Entity> addList = new ArrayList<Entity>();
            addList.add(newEntity);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "Bad input value";
        }
    }

    @GetMapping("/searchv3")
    @ApiOperation(value="查询City", notes="searchCity")
    @ApiImplicitParam(name="city", value="城市名称", required = true, dataType = "String")
    public List<Entity> searchv3(@RequestParam(value="city", required=true) String cityName) {
        List<Entity> entityList = null;
        if(StringUtils.isNotEmpty(cityName)) {
            entityList = cityESService.searchEntity(cityName);
        }
        return entityList;
    }

}
