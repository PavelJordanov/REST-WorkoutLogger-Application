INSERT INTO programs (id, name, done) VALUES ('program1', '12 week hypertrophy', FALSE);

INSERT INTO weeks (id, programId, done) VALUES ('week1', 'program1', FALSE);
INSERT INTO weeks (id, programId, done) VALUES ('week2', 'program1', FALSE);

INSERT INTO workouts (id, weekId, name, done) VALUES ('w1', 'week1', 'Leg Day', FALSE);
INSERT INTO workouts (id, weekId, name, done) VALUES ('w2', 'week2', 'Upper Body', FALSE);

INSERT INTO exercises (id, workoutId, name, sets, reps, weight, done) VALUES ('e1', 'w1', 'Squats', 4, 12, 100, FALSE);
INSERT INTO exercises (id, workoutId, name, sets, reps, weight, done) VALUES ('e2', 'w2', 'Bench Press', 4, 10, 150, FALSE);

INSERT INTO workout_exercises (workout_id, exercise_id) VALUES ('w1', 'e1');