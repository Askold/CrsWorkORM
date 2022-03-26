package ru.sfedu.assister.lab5.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import ru.sfedu.assister.lab5.model.*;

import java.util.HashSet;
import java.util.Set;

class DataProviderTest {
    private static final Logger logger = LogManager.getLogger(DataProviderTest.class);
    private static final HqlDataProvider hibernateDP = new HqlDataProvider();
    private static final CriterialDataProvider criteriaDP = new CriterialDataProvider();
    private static final NativeDataProvider nativeDP = new NativeDataProvider();

    private static final FeedbackEntity feedback = new FeedbackEntity(1L, "normal", "normal");
    private static final WorkoutEntity workout = new WorkoutEntity();
    private static final ExerciseEntity exercise1 = new ExerciseEntity(1L, workout, "name1", 1, 12);
    private static final ExerciseEntity exercise2 = new ExerciseEntity(2L, workout, "name2", 2, 13);
    private static final ExerciseEntity exercise3 = new ExerciseEntity(3L, workout, "name3", 3, 14);
    private static final ExerciseEntity exercise4 = new ExerciseEntity(4L, workout, "name4", 4, 15);


    @BeforeClass
    public static void testInsert() {
        Set<ExerciseEntity> exerciseEntities = new HashSet<>();
        exerciseEntities.add(exercise1);
        exerciseEntities.add(exercise2);
        exerciseEntities.add(exercise3);
        exerciseEntities.add(exercise4);
        workout.setFeedback(feedback);
        workout.setType("Flexibility");
        workout.setExercises(exerciseEntities);
        hibernateDP.insert(workout);
    }

    @Test
    public void testGetById() {
        logger.error("HQL TIME:");
        hibernateDP.getById(WorkoutEntity.class, 1L);
        logger.error("CRITERIA TIME:");
        criteriaDP.getById(1L);
        logger.error("NATIVE TIME:");
        nativeDP.getById(1L);
    }

    @Test
    public void testSelectAll(){
        logger.error("HQL TIME:");
        hibernateDP.selectAll();
        logger.error("CRITERIA TIME:");
        criteriaDP.selectAll();
        logger.error("NATIVE TIME:");
        nativeDP.selectAll();
    }

    @AfterClass
    public static void testDelete(){
        hibernateDP.delete(workout);
    }
}