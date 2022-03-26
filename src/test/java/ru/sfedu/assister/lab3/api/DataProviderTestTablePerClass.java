package ru.sfedu.assister.lab3.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.lab3.table_per_class.ClientTablePerClass;
import ru.sfedu.assister.lab3.table_per_class.TrainerTablePerClass;


import java.util.Optional;

class DataProviderTablePerClassTest {

    private static final Logger logger = LogManager.getLogger(DataProviderTablePerClassTest.class);
    static IDataProvider provider = new DataProvider();
    static ClientTablePerClass client= new ClientTablePerClass(
            1L, "customName", "customSurname", 12, 12, 12, null);
    static TrainerTablePerClass trainer = new TrainerTablePerClass(
            2L, "customName", "customSurname", 1, 2);

    @BeforeEach
    void setUp() {
        provider.insert(client);
        provider.insert(trainer);
    }

    @AfterEach
    void tearDown() {
        provider.delete(client);
        provider.delete(trainer);
    }

    @Test
    void getById() {
        Optional<ClientTablePerClass> byId = provider.getById(ClientTablePerClass.class, 1L);
        byId.ifPresent(logger::info);
        byId.ifPresent(o -> Assert.assertEquals(o, client));
    }

    @Test
    void update() {
        TrainerTablePerClass updated = new TrainerTablePerClass(
                2L, "customName", "customSurname", 13, 13);
        boolean a = provider.update(updated);
        Assert.assertTrue(a);
    }
}