package ru.sfedu.assister;

public class Constants {
    public static final String PROPERTIES_PATH = "properties";
    public static final String DEFAULT_CONFIG_PATH ="./src/main/resources/environment.properties";

    //-----------------Hibernate Util-----------------
    public static String LAB1_HBN_CFG = "lab1.hbn_cfg";
    public static final String DEFAULT_HBN_CFG = "def.hbn_cnf";
    public static final String DEFAULT_HBN_CONFIG_PATH = "src/main/resources/hibernate.cfg.xml";
    //-----------------Data source-----------------
    public static final String DEFAULT_CSV_PATH = "csv_path";
    public static final String CSV_EXTENSION = ".csv";
    public static final String DEFAULT_XML_PATH = "xml_path";
    public static final String XML_EXTENSION = ".xml";
    public static final String DEFAULT_ACTOR = "system";
    public static final String CSV_CREATED ="Created new CSV file: ";
    public static final String CSV_PATH_IS = "CSV PATH is :";
    public static final String XML_CREATED ="Created new XML file: ";
    public static final String XML_PATH_IS = "XML PATH is :";
    //--------------------------CRUD-----------------------
    public static final String RECORDS_ADDED = "All records were added";
    public static final String RECORDS_SELECTED = "Records were selected";
    public static final String FOUND = " found";
    public static final String NOT_FOUND = " not found";
    public static final String NOT_UPDATED =" wasn't updated";
    public static final String UPDATED =" updated";
    public static final String DELETED =" deleted";
    public static final String NOT_DELETED =" not deleted";
    public static final String ADDED =" was added";
    public static final String NOT_ADDED =" not added";
    //-----------------Use-case-----------------
    public static final String SOME_COMMENTS = "Some comments";
    public static final String SOME_DESCRIPTION = "Some description";
    public static final String WORKOUT_ESTIMATE = "Workout for client was: ";
    public static final String COMMENTS = "His comments: ";
    public static final String CLIENT_WORKOUT = "Client don't have a workout yet";
    public static final String ID_IS = " ID is ";
    public static final String EXERCISES_WORKOUT =  "Exercises for this workout wasn't found";
    public static final String IMPOSSIBLE_TO_VIEW = "Impossible to view workout";
    public static final String FEEDBACK_SUCCESS = "feedback composed successfully!" ;
    public static final String WORKOUT_EXECUTED = "workout executed successfully!" ;
    public static final String EXERCISE_SUCCESS = "exercise created successfully!" ;
    public static final String WORKOUT_SUCCESS = "workout created successfully!" ;
    public static final String NOT_FINISHED =  "Client hasn't finished workout yet";
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;

    //-----------------History content-----------------
    public static final String HISTORY_ADDED = "New History record added";
    public static final String MONGO_LOCALHOST="mongo_localhost";
    public static final String MONGO_PORT="mongo_port";
    public static final String MONGODB_NAME = "myMongoDb";
    public static final String CONNECTED_TO_MONGO = "Connected to MongoDB";
    public static final String COLLECTION_NAME ="HistoryContent";
    public static final String COLLECTION_CREATED ="MongoDB collection created";
    public static final String COLLECTION_RECIEVED = "MongoDB collection received";

    //public static final String  =;
    //-----------------Database queries-----------------
    public static final String DATABASE_SIZE = "SELECT table_schema, SUM(data_length + index_length)\n" +
            "FROM   information_schema.tables\n" +
            "WHERE table_schema = '%s'";
    public static final Object DATABASE_NAME = "localdb";
    public static final String DATABASE_USERS = "SELECT user FROM mysql.user;";
    public static final String DATABASE_TABLES = "SELECT table_name \n" +
            "FROM information_schema.tables\n" +
            "WHERE table_schema = '%s'";
    public static final String DATABASE_TABLES_TYPE = "SELECT table_type \n" +
            "FROM information_schema.tables\n" +
            "WHERE table_schema = '%s'";
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
    //public static final String  =  ;
}
