package ru.sfedu.assister.lab4.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ExerciseComponent{
    private long id;
    private String name;
    private int weight;
    private int repetitions;

    public ExerciseComponent() {
    }

    public ExerciseComponent(long id, String name, int weight, int repetitions) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.repetitions = repetitions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getRepetitions() {
        return repetitions;
    }

    public void setRepetitions(int repetitions) {
        this.repetitions = repetitions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseComponent that = (ExerciseComponent) o;
        return id == that.id && weight == that.weight && repetitions == that.repetitions && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight, repetitions);
    }

    @Override
    public String toString() {
        return "ExerciseComponent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", repetitions=" + repetitions +
                '}';
    }
}
