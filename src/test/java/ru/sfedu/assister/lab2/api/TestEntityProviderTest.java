package ru.sfedu.assister.lab2.api;

import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.lab2.model.Car;
import ru.sfedu.assister.lab2.model.TestEntity;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TestEntityProviderTest {
    static TestEntity testEntity;
    static TestEntityProvider testEntityProvider;

    @BeforeAll
    public static void init(){
        testEntity = new TestEntity("name", "some description",
                new Date(System.currentTimeMillis()), true,
                new Car("Toyota", "Corolla", 2005, "Japan")
        );
        testEntityProvider = new TestEntityProvider();
        testEntity = testEntityProvider.insert(testEntity);

    }

    @Test
    void getById() {
        Optional<TestEntity> actual = testEntityProvider.getById(testEntity.getId());
        actual.ifPresent(entity -> Assert.assertEquals(entity, testEntity));
    }

    @Test
    void selectAll() {
        List<TestEntity> list = testEntityProvider.selectAll();
        assertNotNull(list.get(0));
        assertEquals(list.get(0), testEntity);
    }

    @Test
    void update() {
        TestEntity updated = new TestEntity(testEntity.getId(), "nameUpdated", "descriptionUpdated",
                new Date(System.currentTimeMillis()), true,
                new Car("Toyota1", "Corolla1", 2006, "Japan"));
        Assert.assertTrue(testEntityProvider.update(updated));
    }

    @AfterAll
    public static void delete(){
        testEntityProvider.delete(testEntity.getId());
    }
}