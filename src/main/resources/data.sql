-- Insert exercises next
INSERT INTO exercise (id, name, sets, reps, weight, done) VALUES ('e1', 'Squats', 4, 12, 100, FALSE);
INSERT INTO exercise (id, name, sets, reps, weight, done) VALUES ('e2', 'Bench Press', 4, 10, 150, FALSE);

-- Insert workouts first
INSERT INTO workout (id, name, done) VALUES ('w1', 'Leg Day', FALSE);
INSERT INTO workout (id, name, done) VALUES ('w2', 'Upper Body', FALSE);
