package ru.sfedu.assister.lab5.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.assister.Constants;
import ru.sfedu.assister.Utils.HibernateUtil;
import ru.sfedu.assister.lab5.model.WorkoutEntity;

import java.util.List;
import java.util.Optional;

public class HqlDataProvider implements IDataProvider{
    private static final Logger logger = LogManager.getLogger(HqlDataProvider.class);
    @Override
    public <T> boolean insert(T object) {
        long start = System.currentTimeMillis();
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB5_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            logger.info(Constants.ADDED);
            long end = System.currentTimeMillis();
            logger.error("Time passed: " + (end - start));
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return false;
    }

    @Override
    public <T> Optional<T> getById(Class<T> tClass, long id) {
        long start = System.currentTimeMillis();
        Transaction transaction = null;
        Optional<T> optional;
        try (Session session = getSession(Constants.LAB5_HBN_CFG)) {
            transaction = session.beginTransaction();
            optional = Optional.ofNullable(session.get(tClass, id));
            transaction.commit();
            logger.info(Constants.FOUND);
            long end = System.currentTimeMillis();
            logger.error("Time passed: " + (end - start));
            return optional;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    @Override
    public <T> boolean update(T object) {
        long start = System.currentTimeMillis();
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB5_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            logger.info(Constants.UPDATED);
            long end = System.currentTimeMillis();
            logger.error("Time passed: " + (end - start));
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public <T> boolean delete(T object) {
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB5_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.delete(object);
            transaction.commit();
            logger.info(Constants.DELETED);
            return true;
        } catch (Exception e){
            logger.error(e);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    public Optional<List<WorkoutEntity>> selectAll() {
        long start = System.currentTimeMillis();
        List<WorkoutEntity> list;
        try (Session session = getSession(Constants.LAB5_HBN_CFG)) {
            list = session.createQuery("from WorkoutEntity", WorkoutEntity.class).list();
            logger.info(Constants.FOUND);
            long end = System.currentTimeMillis();
            logger.error("Time passed: " + (end - start));
            return Optional.ofNullable(list);
        }
    }

    Session getSession(String hbn_cnf){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(hbn_cnf);
        return sessionFactory.openSession();
    }
}
