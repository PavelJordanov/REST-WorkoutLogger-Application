CREATE TABLE program
(
    id varchar(255) not null,
    name varchar(255) not null,
    done boolean not null,
    primary key(id)
);

CREATE TABLE week
(
    id varchar(255) not null,
    programId varchar(255) not null,
    done Boolean not null,
    primary key(id),
    FOREIGN KEY (programId) REFERENCES program(id)
);

CREATE TABLE workout
(
    id varchar(255) not null,
    weekId varchar(255) not null,
    name varchar(255) not null,
    done boolean not null,
    primary key(id),
    FOREIGN KEY (weekId) REFERENCES week(id)
);

CREATE TABLE exercise
(
    id varchar(255) not null,
    workoutId varchar(255) not null, 
    name varchar(255) not null,
    sets int not null,
    reps int not null,
    weight float not null,
    done boolean not null,
    primary key(id),
    FOREIGN KEY (workoutId) REFERENCES workout(id),
    UNIQUE(name, sets, reps, weight)
);

CREATE TABLE workout_exercises
(
    workout_id varchar(255) not null,
    exercise_id varchar(255) not null,
    PRIMARY KEY (workout_id, exercise_id),
    FOREIGN KEY (workout_id) REFERENCES workout(id),
    FOREIGN KEY (exercise_id) REFERENCES exercise(id)
);

CREATE TABLE week_workouts
(
    week_id varchar(255) not null,
    workout_id varchar(255) not null,
    PRIMARY KEY (week_id, workout_id),
    FOREIGN KEY (week_id) REFERENCES week(id),
    FOREIGN KEY (workout_id) REFERENCES workout(id)
);

CREATE TABLE program_weeks
(
    program_id varchar(255) not null,
    week_id varchar(255) not null,
    PRIMARY KEY (program_id, week_id),
    FOREIGN KEY (program_id) REFERENCES program(id),
    FOREIGN KEY (week_id) REFERENCES week(id)
);