package github.aquan.service.impl;

import com.alibaba.fastjson.JSONObject;
import github.aquan.entity.Entity;
import github.aquan.service.TestService;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.*;
import io.searchbox.indices.ClearCache;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Class TestServiceImpl
 * @Description TODO
 * @Author Aquan
 * @Date 2019.4.17 17:45
 * @Version 1.0
 **/
@Service
public class TestServiceImpl implements TestService {

    private  static final Logger LOGGER = LoggerFactory.getLogger(TestServiceImpl.class);

    @Autowired
    private JestClient jestClient;

    @Override
    public void saveEntity(Entity entity) {
        Index index = new Index.Builder(entity).index(Entity.INDEX_NAME).type(Entity.TYPE).build();
        try {
            jestClient.execute(index);
            LOGGER.info("ES-插入完成");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }

    }

    /**
     * 批量保存内容到ES
     **/
    @Override
    public void saveEntity(List<Entity> entityList) {
        Bulk.Builder bulk = new Bulk.Builder();
        for(Entity entity : entityList) {
            Index index = new Index.Builder(entity).index(Entity.INDEX_NAME).type(Entity.TYPE).build();
            bulk.addAction(index);
        }
        try {
            jestClient.execute(bulk.build());
            LOGGER.info("ES-插入完成");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }

        ClearCache clearCache = new ClearCache.Builder().build();
    }

    /**
     * 在ES中搜索
     **/
    @Override
    public List<Entity> searchEntity(String searchContent) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //查询字段queryStringQuery
        //searchSourceBuilder.query(QueryBuilders.queryStringQuery(searchContent));
        //searchSourceBuilder.field("name");

        //matchQuery匹配
        searchSourceBuilder.query(QueryBuilders.matchQuery("name",searchContent));
        Search search = new Search.Builder(searchSourceBuilder.toString()).addIndex(Entity.INDEX_NAME).addType(Entity.TYPE).build();
        try {
            JestResult result = jestClient.execute(search);
            return result.getSourceAsObjectList(Entity.class);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * 刪除ES中ID匹配的数据
     **/
    @Override
    public boolean deleteEntity(String id) {
        Delete delete = new Delete.Builder(id).index(Entity.INDEX_NAME).type(Entity.TYPE).build();
        DocumentResult result = null;
        try {
            result = jestClient.execute(delete);
            LOGGER.info("deleteEntity resp: {}", result.getJsonString());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }
        if (result.isSucceeded()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateEntity(Entity entity) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("doc", entity);
        Update update = new Update.Builder(jsonObject.toJSONString()).index(Entity.INDEX_NAME).type(Entity.TYPE).id(entity.getId() + "").build();
        try {
            JestResult result = jestClient.execute(update);
            LOGGER.info(result.getJsonString());
            return result.isSucceeded();
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("updateByDocId fail. msg:{}", e.getMessage());
        }
        return false;
    }


}
