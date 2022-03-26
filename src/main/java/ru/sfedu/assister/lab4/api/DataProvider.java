package ru.sfedu.assister.lab4.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.assister.Constants;
import ru.sfedu.assister.Utils.HibernateUtil;

import java.util.Optional;

public class DataProvider implements IDataProvider{
    private static final Logger logger = LogManager.getLogger(DataProvider.class);
    @Override
    public <T> boolean insert(T object) {
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB4_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.save(object);
            transaction.commit();
            logger.info(Constants.ADDED);
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
        Transaction transaction = null;
        Optional<T> optional;
        try (Session session = getSession(Constants.LAB4_HBN_CFG)) {
            transaction = session.beginTransaction();
            optional = Optional.ofNullable(session.get(tClass, id));
            transaction.commit();
            logger.info(Constants.FOUND);
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
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB4_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.update(object);
            transaction.commit();
            logger.info(Constants.UPDATED);
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
        try (Session session = getSession(Constants.LAB4_HBN_CFG)) {
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

    Session getSession(String hbn_cnf){
        logger.info("start getSession()");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(hbn_cnf);
        return sessionFactory.openSession();
    }
}
