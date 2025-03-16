CREATE TABLE programs
(
    id varchar(255) not null,
    name varchar(255) not null,
    done boolean not null,
    primary key(id)
);

CREATE TABLE weeks
(
    id varchar(255) not null,
    programId varchar(255) not null,
    done Boolean not null,
    primary key(id),
    FOREIGN KEY (programId) REFERENCES programs(id)
);

CREATE TABLE workouts
(
    id varchar(255) not null,
    weekId varchar(255) not null,
    name varchar(255) not null,
    done boolean not null,
    primary key(id),
    FOREIGN KEY (weekId) REFERENCES weeks(id)
);

CREATE TABLE exercises
(
    id varchar(255) not null,
    workoutId varchar(255) not null, 
    name varchar(255) not null,
    sets int not null,
    reps int not null,
    weight float not null,
    done boolean not null,
    primary key(id),
    FOREIGN KEY (workoutId) REFERENCES workouts(id)
    
);

CREATE TABLE workout_exercises
(
    workout_id varchar(255) not null,
    exercise_id varchar(255) not null,
    PRIMARY KEY (workout_id, exercise_id),
    FOREIGN KEY (workout_id) REFERENCES workouts(id),
    FOREIGN KEY (exercise_id) REFERENCES exercises(id)
);

CREATE TABLE week_workouts
(
    week_id varchar(255) not null,
    workout_id varchar(255) not null,
    PRIMARY KEY (week_id, workout_id),
    FOREIGN KEY (week_id) REFERENCES weeks(id),
    FOREIGN KEY (workout_id) REFERENCES workouts(id)
);

CREATE TABLE program_weeks
(
    program_id varchar(255) not null,
    week_id varchar(255) not null,
    PRIMARY KEY (program_id, week_id),
    FOREIGN KEY (program_id) REFERENCES programs(id),
    FOREIGN KEY (week_id) REFERENCES weeks(id)
);