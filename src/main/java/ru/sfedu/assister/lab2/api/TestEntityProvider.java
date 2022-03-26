package ru.sfedu.assister.lab2.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.sfedu.assister.Constants;
import ru.sfedu.assister.Utils.HibernateUtil;
import ru.sfedu.assister.lab2.model.TestEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestEntityProvider implements ITestEntityProvider{

    private static final Logger logger = LogManager.getLogger(TestEntityProvider.class);

    @Override
    public TestEntity insert(TestEntity testEntity) {
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB2_HBN_CFG)){
            transaction = session.beginTransaction();
            testEntity = (TestEntity) session.merge(testEntity);
            transaction.commit();
            logger.info(testEntity.getClass().getSimpleName()+Constants.ADDED);
            return testEntity;
        }
        catch (Exception e){
            e.printStackTrace();
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null){
                transaction.rollback();
            }
        }
        return testEntity;
    }

    @Override
    public Optional<TestEntity> getById(long id) {
        Transaction transaction = null;
        Optional<TestEntity> optional;
        try (Session session = getSession(Constants.LAB2_HBN_CFG)) {
            transaction = session.beginTransaction();
            optional = Optional.ofNullable(session.get(TestEntity.class, id));
            transaction.commit();
            logger.info(TestEntity.class.getSimpleName()+Constants.FOUND);
            return optional;
        } catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return Optional.empty();
        }
    }

    @Override
    public List<TestEntity> selectAll() {
        Transaction transaction = null;
        List<TestEntity> list = new ArrayList<>();
        try (Session session = getSession(Constants.LAB2_HBN_CFG)){
            list = session.createQuery("from TestEntity ", TestEntity.class).list();
            logger.info(Constants.RECORDS_SELECTED);
            return list;
        }
        catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            return list;
        }
    }

    @Override
    public boolean update(TestEntity testEntity) {
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB2_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.update(testEntity);
            transaction.commit();
            logger.info(testEntity.getClass().getSimpleName()+Constants.UPDATED);
            return true;
        } catch (Exception e){
            logger.error(e.getClass() + e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean delete(long id) {
        Transaction transaction = null;
        try (Session session = getSession(Constants.LAB2_HBN_CFG)) {
            transaction = session.beginTransaction();
            session.delete(new TestEntity(id));
            transaction.commit();
            logger.info(TestEntity.class.getSimpleName()+id+Constants.DELETED);
            return true;
        } catch (Exception e){
            logger.error(e.getClass()+e.getMessage());
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
    }

    Session getSession(String hbn_cnf){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(hbn_cnf);
        return sessionFactory.openSession();
    }
}
