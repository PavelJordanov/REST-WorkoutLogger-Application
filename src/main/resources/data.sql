INSERT INTO exercise (id, name, sets, reps, weight, done) VALUES ('e1', 'Squats', 4, 12, 100, FALSE);
INSERT INTO exercise (id, name, sets, reps, weight, done) VALUES ('e2', 'Bench Press', 4, 10, 150, FALSE);

INSERT INTO workout (id, name, done) VALUES ('w1', 'Leg Day', FALSE);
INSERT INTO workout (id, name, done) VALUES ('w2', 'Upper Body', FALSE);

INSERT INTO workout_exercises (workout_id, exercise_id) VALUES ('w1', 'e1');