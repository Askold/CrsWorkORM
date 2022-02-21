package ru.sfedu.assister.lab1.api;

import java.util.Optional;

public interface IHibernateDataProvider {
    Optional<String> getDatabaseSize(String hbn_cnf);

    Optional<String> getUsers(String hbn_cnf);

    Optional<String> getTables(String hbn_cnf);

    Optional<String> getTablesDatatype(String hbn_cnf);
}
