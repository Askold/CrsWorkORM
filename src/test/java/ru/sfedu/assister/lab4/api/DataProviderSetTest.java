package ru.sfedu.assister.lab4.api;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.lab4.model.WorkoutSet;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DataProviderSetTest {
    static IDataProvider dp = new DataProvider();
    static Set<String> exercises = new HashSet<>();
    static WorkoutSet workout = new WorkoutSet();

    @BeforeClass
    public static void testInsert() {
        exercises.add("exercise1");
        exercises.add("exercise2");
        workout.setExercises(exercises);
        dp.insert(workout);
    }

    @Test
    public void testGetById() {
        Optional<WorkoutSet> byID = dp.getById(WorkoutSet.class, workout.getId());
        if(byID.isPresent()){
            Assert.assertEquals(byID.get(), workout);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testUpdate() {
        exercises = exercises.stream().map(o -> o + "Updated").collect(Collectors.toSet());
        WorkoutSet updated = new WorkoutSet(workout.getId(), exercises, 1L);
        Assert.assertTrue(dp.update(updated));
    }

    @AfterClass
    public static void testDelete() {
        dp.delete(workout);
    }
}