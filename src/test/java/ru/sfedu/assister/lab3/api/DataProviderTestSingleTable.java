package ru.sfedu.assister.lab3.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.lab3.single_table.ClientSingleTable;
import ru.sfedu.assister.lab3.single_table.TrainerSingleTable;

import java.util.Optional;

class DataProviderSingleTableTest {

    private static final Logger logger = LogManager.getLogger(DataProviderSingleTableTest.class);
    static IDataProvider provider = new DataProvider();
    static ClientSingleTable client= new ClientSingleTable(
            1L, "customName", "customSurname", 12, 12, 12, null);
    static TrainerSingleTable trainer = new TrainerSingleTable(
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
        Optional<ClientSingleTable> byId = provider.getById(ClientSingleTable.class, 1L);
        byId.ifPresent(logger::info);
        byId.ifPresent(o -> Assert.assertEquals(o, client));
    }

    @Test
    void update() {
        TrainerSingleTable updated = new TrainerSingleTable(
                2L, "customName", "customSurname", 13, 13);
        boolean a = provider.update(updated);
        Assert.assertTrue(a);
    }
}