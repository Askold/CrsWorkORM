package ru.sfedu.assister.lab3.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.lab3.mapped_superclass.ClientMappedSuperClass;
import ru.sfedu.assister.lab3.mapped_superclass.TrainerMappedSuperClass;

import java.util.Optional;

class DataProviderMappedSuperClassTest {
    private static final Logger logger = LogManager.getLogger(DataProviderMappedSuperClassTest.class);
    static IDataProvider provider = new DataProvider();
    static ClientMappedSuperClass client= new ClientMappedSuperClass(
            1L, "customName", "customSurname", 12, 12, 12, null);
    static TrainerMappedSuperClass trainer = new TrainerMappedSuperClass(
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
        Optional<ClientMappedSuperClass> byId = provider.getById(ClientMappedSuperClass.class, 1L);
        byId.ifPresent(logger::info);
        byId.ifPresent(o -> Assert.assertEquals(o, client));
    }

    @Test
    void update() {
        TrainerMappedSuperClass updated = new TrainerMappedSuperClass(
                2L, "customName", "customSurname", 13, 13);
        boolean a = provider.update(updated);
        Assert.assertTrue(a);
    }

}