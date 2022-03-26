package ru.sfedu.assister.lab4.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Entity
public class WorkoutList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "exerciseList")
    @OrderColumn
    @Column(name = "exercises")
    private List<String> exercises = new ArrayList<>();
    private long client;

    public WorkoutList() {
    }

    public WorkoutList(long id, List<String> exercises, long client) {
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

    public List<String> getExercises() {
        return exercises;
    }

    public void setExercises(List<String> exercises) {
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
        WorkoutList that = (WorkoutList) o;
        return id == that.id && client == that.client && Objects.equals(exercises, that.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, exercises, client);
    }

    @Override
    public String toString() {
        return "WorkoutList{" +
                "id=" + id +
                ", exercises=" + exercises +
                ", client=" + client +
                '}';
    }
}
