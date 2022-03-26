package ru.sfedu.assister.lab2.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
public class TestEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private Date dateCreated;
    @Column(name = "checked")
    private Boolean check;
    @Embedded
    private Car car;

    public TestEntity(Long id, String name, String description, Date dateCreated, Boolean check, Car car) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.check = check;
        this.car = car;
    }

    public TestEntity(String name, String description, Date dateCreated, Boolean check, Car car) {
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.check = check;
        this.car = car;
    }

    public TestEntity(Long id) {
        this.id = id;
    }

    public TestEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateCreated=" + dateCreated +
                ", check=" + check +
                ", car=" + car +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestEntity that = (TestEntity) o;
        return id.equals(that.id) && name.equals(that.name) && description.equals(that.description) &&
                dateCreated.toString().equals(that.dateCreated.toString()) &&
                check.equals(that.check) && car.equals(that.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateCreated.toString(), check, car);
    }
}
