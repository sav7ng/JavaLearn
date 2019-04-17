package github.aquan.service.impl;

import github.aquan.entity.Entity;
import github.aquan.service.TestService;
import io.searchbox.core.Index;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.searchbox.client.JestClient;

import java.io.IOException;
import java.util.List;

/**
 * @Class TestServiceImpl
 * @Description TODO
 * @Author Aquan
 * @Date 2019.4.17 17:45
 * @Version 1.0
 **/
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
            LOGGER.error(e.getMessage();
        }

    }

    /**
     * 批量保存内容到ES
     **/

    @Override
    public void saveEntity(List<Entity> entityList) {

    }

    @Override
    public List<Entity> searchEntity(String searchContent) {
        return null;
    }
}
