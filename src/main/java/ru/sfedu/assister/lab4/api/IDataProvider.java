package ru.sfedu.assister.lab4.api;

import java.util.Optional;

public interface IDataProvider {
    <T> boolean insert(T object);
    <T> Optional<T> getById(Class<T> tClass, long id);
    <T> boolean update(T object);
    <T> boolean delete(T object);
}
