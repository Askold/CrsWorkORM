package ru.sfedu.assister.lab1.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.Constants;

class HibernateDataProviderTest {
    private static final Logger logger = LogManager.getLogger(HibernateDataProviderTest.class);

    @Test
    void getDatabaseSize() {
        HibernateDataProvider hibernateDataProvider = new HibernateDataProvider();
        Assert.assertTrue(hibernateDataProvider.getDatabaseSize(Constants.DEFAULT_HBN_CONFIG_PATH).isPresent());
        Assert.assertNotNull(hibernateDataProvider.getDatabaseSize(Constants.DEFAULT_HBN_CONFIG_PATH).get());
        logger.info(hibernateDataProvider.getDatabaseSize(Constants.DEFAULT_HBN_CONFIG_PATH).get());
    }

    @Test
    void getUsers() {
        HibernateDataProvider hibernateDataProvider = new HibernateDataProvider();
        Assert.assertTrue(hibernateDataProvider.getUsers(Constants.DEFAULT_HBN_CONFIG_PATH).isPresent());
        Assert.assertNotNull(hibernateDataProvider.getUsers(Constants.DEFAULT_HBN_CONFIG_PATH).get());
        logger.info(hibernateDataProvider.getUsers(Constants.DEFAULT_HBN_CONFIG_PATH).get());
    }

    @Test
    void getTables() {
        HibernateDataProvider hibernateDataProvider = new HibernateDataProvider();
        Assert.assertTrue(hibernateDataProvider.getTables(Constants.DEFAULT_HBN_CONFIG_PATH).isPresent());
        Assert.assertNotNull(hibernateDataProvider.getTables(Constants.DEFAULT_HBN_CONFIG_PATH).get());
        logger.info(hibernateDataProvider.getTables(Constants.DEFAULT_HBN_CONFIG_PATH).get());
    }

    @Test
    void getTablesDatatype() {
        HibernateDataProvider hibernateDataProvider = new HibernateDataProvider();
        Assert.assertTrue(hibernateDataProvider.getTablesDatatype(Constants.DEFAULT_HBN_CONFIG_PATH).isPresent());
        Assert.assertNotNull(hibernateDataProvider.getTablesDatatype(Constants.DEFAULT_HBN_CONFIG_PATH).get());
        logger.info(hibernateDataProvider.getTablesDatatype(Constants.DEFAULT_HBN_CONFIG_PATH).get());
    }
}