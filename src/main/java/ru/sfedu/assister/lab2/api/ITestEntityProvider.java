package ru.sfedu.assister.lab2.api;

import ru.sfedu.assister.lab2.model.TestEntity;

import java.util.List;
import java.util.Optional;

public interface ITestEntityProvider {
    TestEntity insert(TestEntity testEntity);
    Optional<TestEntity> getById(long id);
    List<TestEntity> selectAll();
    boolean update(TestEntity testEntity);
    boolean delete(long id);
}
