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
            @ApiImplicitParam(name="id", value="城市ID", required=true, dataType="long",defaultValue = "0"),
            @ApiImplicitParam(name="cityName", value="城市名称", required=true, dataType="string")})
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

    @PostMapping(value="/saveList")
    @ApiOperation(value="批量保存City", notes="saveListCity")
    public String save(@RequestBody List<Entity> entityList) {
        return cityESService.saveEntity(entityList) ? "批量导入成功" : "批量导入失败";
    }

    @GetMapping(value="/search")
    @ApiOperation(value="查询City", notes="searchCity")
    @ApiImplicitParam(name="cityName", value="城市名称", required = true, dataType = "string")
    public List<Entity> search(String cityName) {
        List<Entity> entityList = null;
        if(StringUtils.isNotEmpty(cityName)) {
            entityList = cityESService.searchEntity(cityName);
        }
        return entityList;
    }

    @DeleteMapping(value = "/delete")
    @ApiOperation(value = "根据城市ID删除数据", notes="deleteCity")
    @ApiImplicitParam(name = "cityId", value = "城市ID", required = true, dataType = "string")
    public String delete(@RequestParam(value="cityId", required = true) String id) {
        return cityESService.deleteEntity(id) ? "删除成功" : "删除失败";
    }

    @PostMapping(value = "/update")
    @ApiOperation(value = "更新城市数据", notes="updateCity")
    public String update(@RequestBody Entity entity) {
        return cityESService.updateEntity(entity) ? "更新成功" : "更新失败";
    }

    // @GetMapping("/savev2")
    // @ApiOperation(value="保存City", notes="saveCity")
    // // @ApiImplicitParams({
    // //         @ApiImplicitParam(name="id", value="城市ID", required=true, dataType="long"),
    // //         @ApiImplicitParam(name="cityName", value="城市名称", required=true, dataType="string")})
    // public String savev2(@RequestParam(value="id", required=true) long id,
    //                      @RequestParam(value="cityName", required=true) String cityName) {
    //     System.out.println("save_Api");
    //     if(id>0 && StringUtils.isNotEmpty(cityName)) {
    //         Entity newEntity = new Entity(id, cityName);
    //         List<Entity> addList = new ArrayList<Entity>();
    //         addList.add(newEntity);
    //         cityESService.saveEntity(addList);
    //         return "OK";
    //     }else {
    //         return "Bad input value";
    //     }
    // }
    //
    // @GetMapping("/searchv2")
    // @ApiOperation(value="查询City", notes="searchCity")
    // // @ApiImplicitParam(name="cityName", value="城市名称", required = true, dataType = "string")
    // public List<Entity> searchv2(@RequestParam(value="cityName", required=true) String cityName) {
    //     List<Entity> entityList = null;
    //     if(StringUtils.isNotEmpty(cityName)) {
    //         entityList = cityESService.searchEntity(cityName);
    //     }
    //     return entityList;
    // }
    //
    // @GetMapping("/savev3")
    // @ApiOperation(value="保存City", notes="saveCity")
    // @ApiImplicitParams({
    //         @ApiImplicitParam(name="id", value="城市ID", required=true, dataType="long"),
    //         @ApiImplicitParam(name="city", value="城市名称", required=true, dataType="string")})
    // public String savev3(@RequestParam(value="id", required=true) long id,
    //                      @RequestParam(value="city", required=true) String cityName) {
    //     System.out.println("save_Api");
    //     if(id>0 && StringUtils.isNotEmpty(cityName)) {
    //         Entity newEntity = new Entity(id, cityName);
    //         List<Entity> addList = new ArrayList<Entity>();
    //         addList.add(newEntity);
    //         cityESService.saveEntity(addList);
    //         return "OK";
    //     }else {
    //         return "Bad input value";
    //     }
    // }
    //
    // @GetMapping("/searchv3")
    // @ApiOperation(value="查询City", notes="searchCity")
    // @ApiImplicitParam(name="city", value="城市名称", required = true, dataType = "string")
    // public List<Entity> searchv3(@RequestParam(value="city", required=true) String cityName) {
    //     List<Entity> entityList = null;
    //     if(StringUtils.isNotEmpty(cityName)) {
    //         entityList = cityESService.searchEntity(cityName);
    //     }
    //     return entityList;
    // }

}
