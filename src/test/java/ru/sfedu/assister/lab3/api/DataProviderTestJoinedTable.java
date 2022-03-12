package ru.sfedu.assister.lab3.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.lab3.joined_table.ClientJoinedTable;
import ru.sfedu.assister.lab3.joined_table.TrainerJoinedTable;

import java.util.Optional;

class DataProviderJoinedTableTest {

    private static final Logger logger = LogManager.getLogger(DataProviderJoinedTableTest.class);
    static IDataProvider provider = new DataProvider();
    static ClientJoinedTable client= new ClientJoinedTable(
            1L, "customName", "customSurname", 12, 12, 12, null);
    static TrainerJoinedTable trainer = new TrainerJoinedTable(
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
        Optional<ClientJoinedTable> byId = provider.getById(ClientJoinedTable.class, 1L);
        byId.ifPresent(logger::info);
        byId.ifPresent(structuredMedicineJoinedTable -> Assert.assertEquals(structuredMedicineJoinedTable, client));
    }

    @Test
    void update() {
        TrainerJoinedTable updated = new TrainerJoinedTable(
                2L, "customName", "customSurname", 13, 13);
        boolean a = provider.update(updated);
        Assert.assertTrue(a);
    }
}