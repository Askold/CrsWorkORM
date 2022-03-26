package ru.sfedu.assister.lab4.api;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.sfedu.assister.lab4.model.WorkoutList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class DataProviderListTest {
    static IDataProvider dp = new DataProvider();
    static List<String> exercises = new ArrayList<>();
    static WorkoutList workoutList = new WorkoutList();
    @BeforeClass
    public static void testInsert() {
        exercises.add("note1");
        exercises.add("note2");
        workoutList.setExercises(exercises);
        dp.insert(workoutList);
    }

    @Test
    public void testGetById() {
        Optional<WorkoutList> byID = dp.getById(WorkoutList.class, workoutList.getId());
        if(byID.isPresent()){
            Assert.assertEquals(byID.get(), workoutList);
        } else {
            Assert.fail();
        }
    }

    @Test
    public void testUpdate() {
        exercises = exercises.stream().map(note -> note + "Updated").collect(Collectors.toList());
        WorkoutList updated = new WorkoutList(workoutList.getId(), exercises, 1L);
        Assert.assertTrue(dp.update(updated));
    }

    //    @AfterClass
    public static void testDelete() {
        dp.delete(workoutList);
    }

}