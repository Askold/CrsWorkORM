package ru.sfedu.assister.lab5.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sfedu.assister.Constants;
import ru.sfedu.assister.Utils.HibernateUtil;
import ru.sfedu.assister.lab5.model.WorkoutEntity;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public class CriterialDataProvider{
    private static final Logger logger = LogManager.getLogger(CriterialDataProvider.class);

    public Optional<WorkoutEntity> getById(long id){
        long start = System.currentTimeMillis();
        try (Session session = getSession(Constants.LAB5_HBN_CFG)){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<WorkoutEntity> cr = cb.createQuery(WorkoutEntity.class);
            Root<WorkoutEntity> root = cr.from(WorkoutEntity.class);
            cr.select(root).where(cb.gt(root.get("id"), id));
            Query query = session.createQuery(cr);
            List<WorkoutEntity> results = query.getResultList();
            long end = System.currentTimeMillis();
            logger.error("Time passed: " + (end - start));
            if (results.size() > 0){
                return Optional.of(results.get(0));
            }
            return Optional.empty();
        }
    }

    public Optional<List<WorkoutEntity>> selectAll(){
        long start = System.currentTimeMillis();
        try (Session session = getSession(Constants.LAB5_HBN_CFG)){
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<WorkoutEntity> cr = cb.createQuery(WorkoutEntity.class);
            Root<WorkoutEntity> root = cr.from(WorkoutEntity.class);
            cr.select(root);
            Query query = session.createQuery(cr);
            List<WorkoutEntity> results = query.getResultList();
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
