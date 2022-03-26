package ru.sfedu.assister.lab5.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.assister.Constants;
import ru.sfedu.assister.Utils.HibernateUtil;
import ru.sfedu.assister.lab5.model.WorkoutEntity;


import java.util.List;
import java.util.Optional;

public class NativeDataProvider {
    private static final Logger logger = LogManager.getLogger(NativeDataProvider.class);

    public Optional<WorkoutEntity> getById(long id){
        long start = System.currentTimeMillis();
        try (Session session = getSession(Constants.LAB5_HBN_CFG)){
            NativeQuery<WorkoutEntity> query = session.createNativeQuery("select * from WorkoutEntity where id = " + id, WorkoutEntity.class);
            List<WorkoutEntity> results = query.list();
            if (results.size() > 0){
                long end = System.currentTimeMillis();
                logger.error("Time passed: " + (end - start));
                return Optional.of(results.get(0));
            }
            return Optional.empty();
        }
    }
    public Optional<List<WorkoutEntity>> selectAll(){
        long start = System.currentTimeMillis();
        try (Session session = getSession(Constants.LAB5_HBN_CFG)){
            NativeQuery<WorkoutEntity> query = session.createNativeQuery("select * from WorkoutEntity", WorkoutEntity.class);
            List<WorkoutEntity> results = query.list();
            long end = System.currentTimeMillis();
            logger.error("Time passed: " + (end - start));
            return Optional.of(results);
        }
    }

    Session getSession(String hbn_cnf){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(hbn_cnf);
        return sessionFactory.openSession();
    }
}
