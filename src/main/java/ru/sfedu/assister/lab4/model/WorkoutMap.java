package ru.sfedu.assister.lab4.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Entity
public class WorkoutMap {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "exerciseMap")
    @MapKeyColumn(name = "exerciseName")
    @Column(name = "exerciseForm")
    private Map<String, String> exercises = new HashMap<>();
    private long client;

    public WorkoutMap() {
    }

    public WorkoutMap(long id, Map<String, String> exercises, long client) {
        this.id = id;
        this.exercises = exercises;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, String> getExercises() {
        return exercises;
    }

    public void setExercises(Map<String, String> exercises) {
        this.exercises = exercises;
    }

    public long getClient() {
        return client;
    }

    public void setClient(long client) {
        this.client = client;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutMap that = (WorkoutMap) o;
        return id == that.id && client == that.client && Objects.equals(exercises, that.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercises, client);
    }

    @Override
    public String toString() {
        return "WorkoutMap{" +
                "id=" + id +
                ", exercises=" + exercises +
                ", client=" + client +
                '}';
    }
}
