package ru.sfedu.assister.lab1.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import ru.sfedu.assister.Constants;

import java.util.List;
import java.util.Optional;

public class HibernateDataProvider implements IHibernateDataProvider{

    @Override
    public Optional<String> getDatabaseSize(String hbn_cnf) {
        try (Session session = getSession(hbn_cnf)){
            NativeQuery query1 = session.createNativeQuery(
                    String.format(Constants.DATABASE_SIZE, Constants.DATABASE_NAME));
            List resultList = query1.getResultList();
            if (resultList == null){
                return Optional.empty();
            } else {
                Object[] o = (Object[]) resultList.get(0);
                return Optional.of(o[1].toString());
            }
        }
    }

    @Override
    public Optional<String> getUsers(String hbn_cnf) {
        try (Session session = getSession(hbn_cnf)){
            NativeQuery query1 = session.createNativeQuery(Constants.DATABASE_USERS);
            List resultList = query1.getResultList();
            return getString(resultList);
        }
    }

    @Override
    public Optional<String> getTables(String hbn_cnf) {
        try (Session session = getSession(hbn_cnf)){
            NativeQuery query1 = session.createNativeQuery(
                    String.format(Constants.DATABASE_TABLES, Constants.DATABASE_NAME));
            List resultList = query1.getResultList();
            return getString(resultList);
        }
    }

    @Override
    public Optional<String> getTablesDatatype(String hbn_cnf) {
        try (Session session = getSession(hbn_cnf)){
            NativeQuery query1 = session.createNativeQuery(String.format(
                    Constants.DATABASE_TABLES_TYPE, Constants.DATABASE_NAME));
            List resultList = query1.getResultList();
            return getString(resultList);
        }
    }
    Session getSession(String hbn_cnf){
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory(hbn_cnf);
        return sessionFactory.openSession();
    }

    Optional<String> getString(List result){
        if (result == null){
            return Optional.empty();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            for (Object o:result) {
                stringBuilder.append(o.toString()).append("\t");
            }
            return Optional.of(stringBuilder.toString());
        }
    }
}

