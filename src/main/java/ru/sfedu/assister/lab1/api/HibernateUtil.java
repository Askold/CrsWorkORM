package ru.sfedu.assister.lab1.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import ru.sfedu.assister.Constants;
import ru.sfedu.assister.Utils.ConfigurationUtil;
import ru.sfedu.assister.lab1.model.*;
import ru.sfedu.assister.lab2.model.TestEntity;
import ru.sfedu.assister.lab3.joined_table.ClientJoinedTable;
import ru.sfedu.assister.lab3.joined_table.TrainerJoinedTable;
import ru.sfedu.assister.lab3.joined_table.UserJoinedTable;
import ru.sfedu.assister.lab3.mapped_superclass.ClientMappedSuperClass;
import ru.sfedu.assister.lab3.mapped_superclass.TrainerMappedSuperClass;
import ru.sfedu.assister.lab3.mapped_superclass.UserMappedSuperClass;
import ru.sfedu.assister.lab3.single_table.ClientSingleTable;
import ru.sfedu.assister.lab3.single_table.TrainerSingleTable;
import ru.sfedu.assister.lab3.single_table.UserSingleTable;
import ru.sfedu.assister.lab3.table_per_class.ClientTablePerClass;
import ru.sfedu.assister.lab3.table_per_class.TrainerTablePerClass;
import ru.sfedu.assister.lab3.table_per_class.UserTablePerClass;

import java.io.File;
import java.io.IOException;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class);

    public static SessionFactory getSessionFactory(String configFile) {
        logger.info("start getSessionFactory()");
        File file = new File(configFile);
        String consoleConfig = null;
        try {
            consoleConfig = ConfigurationUtil.getConfigurationEntry(Constants.DEFAULT_HBN_CFG);
        } catch (IOException e) {
            logger.error(e);
        }
        if (consoleConfig != null) {
            file = new File(consoleConfig);
        }
        if (!file.exists()) {
            file = new File(Constants.DEFAULT_HBN_CONFIG_PATH);
        }
        logger.debug("file name: " + file.getName());
        Configuration configuration = new Configuration().configure(file);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        MetadataSources metadataSources = new MetadataSources(serviceRegistry);

        metadataSources.addAnnotatedClass(TestEntity.class);

//        metadataSources.addAnnotatedClass(ClientEntity.class);
//        metadataSources.addAnnotatedClass(ExerciseEntity.class);
//        metadataSources.addAnnotatedClass(FeedbackEntity.class);
//        metadataSources.addAnnotatedClass(TrainerEntity.class);
//        metadataSources.addAnnotatedClass(WorkoutEntity.class);

          metadataSources.addAnnotatedClass(ClientJoinedTable.class);
          metadataSources.addAnnotatedClass(TrainerJoinedTable.class);
          metadataSources.addAnnotatedClass(UserJoinedTable.class);

          metadataSources.addAnnotatedClass(ClientMappedSuperClass.class);
          metadataSources.addAnnotatedClass(TrainerMappedSuperClass.class);
          metadataSources.addAnnotatedClass(UserMappedSuperClass.class);

          metadataSources.addAnnotatedClass(ClientSingleTable.class);
          metadataSources.addAnnotatedClass(TrainerSingleTable.class);
          metadataSources.addAnnotatedClass(UserSingleTable.class);

          metadataSources.addAnnotatedClass(ClientTablePerClass.class);
          metadataSources.addAnnotatedClass(TrainerTablePerClass.class);
          metadataSources.addAnnotatedClass(UserTablePerClass.class);

        sessionFactory = metadataSources.buildMetadata().buildSessionFactory();
        logger.info("end getSessionFactory()");
        return sessionFactory;
    }
}
