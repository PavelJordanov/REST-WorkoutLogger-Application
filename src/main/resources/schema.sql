CREATE TABLE exercise
(
    id varchar(255) not null,
    name varchar(255) not null,
    sets int not null,
    reps int not null,
    weight float not null,
    done Boolean not null,
    primary key(id),
    UNIQUE(name, sets, reps, weight)
);

CREATE TABLE workout
(
    id varchar(255) not null,
    name varchar(255) not null,
    done Boolean not null,
    primary key(id)
);

CREATE TABLE workout_exercises
(
    workout_id varchar(255) not null,
    exercise_id varchar(255) not null,
    PRIMARY KEY (workout_id, exercise_id),
    FOREIGN KEY (workout_id) REFERENCES workout(id) ON DELETE CASCADE,
    FOREIGN KEY (exercise_id) REFERENCES exercise(id) ON DELETE CASCADE
);

CREATE TABLE week
(
    id varchar(255) not null,
    done Boolean not null,
    primary key(id)
);