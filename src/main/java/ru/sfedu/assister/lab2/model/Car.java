package ru.sfedu.assister.lab2.model;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Car {
    private String brand;
    private String model;
    private Integer year;
    private String country;

    public Car(String brand, String model, Integer year, String country) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.country = country;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return brand.equals(car.brand) && model.equals(car.model) && year.equals(car.year) && country.equals(car.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, country);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", country='" + country + '\'' +
                '}';
    }
}
