INSERT INTO program (id, name, done) VALUES ('program 1', '12 week hypertrophy', FALSE);

INSERT INTO week (id, programId, done) VALUES ('week 1', 'program 1', FALSE);
INSERT INTO week (id, programId, done) VALUES ('week 2', 'program 1', FALSE);

INSERT INTO workout (id, weekId, name, done) VALUES ('w1', 'week 1', 'Leg Day', FALSE);
INSERT INTO workout (id, weekId, name, done) VALUES ('w2', 'week 2', 'Upper Body', FALSE);

INSERT INTO exercise (id, workoutId, name, sets, reps, weight, done) VALUES ('e1', 'w1', 'Squats', 4, 12, 100, FALSE);
INSERT INTO exercise (id, workoutId, name, sets, reps, weight, done) VALUES ('e2', 'w2', 'Bench Press', 4, 10, 150, FALSE);

INSERT INTO workout_exercises (workout_id, exercise_id) VALUES ('w1', 'e1');