package github.aquan.service;

import github.aquan.entity.Entity;

import java.util.List;

public interface TestService {

    void saveEntity(Entity entity);

    void saveEntity(List<Entity> entityList);

    List<Entity> searchEntity(String searchContent);

    boolean deleteEntity(String id);

    boolean updateEntity(Entity entity);

}
