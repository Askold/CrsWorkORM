package ru.sfedu.assister.lab3.mapped_superclass;

import javax.persistence.*;


@MappedSuperclass
public class UserMappedSuperClass {
    @Id
    private long userId;
    @Basic
    private String name;
    @Basic
    private String surname;

    public UserMappedSuperClass() {
    }

    public UserMappedSuperClass(long userId, String name, String surname) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserMappedSuperClass that = (UserMappedSuperClass) o;

        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        return result;
    }
}
