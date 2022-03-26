package ru.sfedu.assister.lab3.table_per_class;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ClientTablePerClass")
public class ClientTablePerClass extends UserTablePerClass{
    @Basic
    private Integer age;
    @Basic
    private Integer weight;
    @Basic
    private Integer height;
    @Basic
    private Byte awaiting;

    public ClientTablePerClass() {
    }

    public ClientTablePerClass(long userId, String name, String surname, Integer age, Integer weight, Integer height, Byte awaiting) {
        super(userId, name, surname);
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.awaiting = awaiting;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Byte getAwaiting() {
        return awaiting;
    }

    public void setAwaiting(Byte awaiting) {
        this.awaiting = awaiting;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientTablePerClass that = (ClientTablePerClass) o;

        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (awaiting != null ? !awaiting.equals(that.awaiting) : that.awaiting != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age != null ? age.hashCode() : 0;
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (awaiting != null ? awaiting.hashCode() : 0);
        return result;
    }
}
