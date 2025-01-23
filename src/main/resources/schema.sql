CREATE TABLE exercise
(
    id varchar(255) not null,
    name varchar(255) not null,
    sets int not null,
    reps int not null,
    weight float not null,
    workout varchar(255) not null,
    primary key(id),
    UNIQUE(sets, reps, weight)
);

CREATE TABLE workout
(
    id varchar(255) not null,
    name varchar(255) not null,
    primary key(id)
);

