package ru.sfedu.assister.lab4.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import ru.sfedu.assister.Constants;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Entity
public class WorkoutComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "exercise_component")
    @Column(name = "exercises")
    private Set<ExerciseComponent> exercises = new HashSet<>();
    private long client;



}
