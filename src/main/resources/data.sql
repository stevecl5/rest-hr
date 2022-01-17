INSERT INTO managers (id, first_name, last_name, email) VALUES
    (1, 'John', 'Smith', 'john.smith@domain.com'),
    (2, 'Julie', 'McDonald', 'julie.mcdonald@domain.com'),
    (3, 'Cindy', 'Lewis', 'cindy.lewis@domain.com');

INSERT INTO team_members (id, first_name, last_name, email, manager_id) VALUES
    (1, 'Jim', 'Dean', 'jim.dean@domain.com', 2),
    (2, 'Robert', 'Boyd', 'robert.boyd@domain.com', 1),
    (3, 'Sarah', 'Thompson', 'sarah.thompson@domain.com', 3),
    (4, 'Chris', 'Lee', 'chris.lee@domain.com', 2),
    (5, 'Andrea', 'Simpson', 'andrea.simpson@domain.com', 3),
    (6, 'Jack', 'Davis', 'jack.davis@domain.com', 1),
    (7, 'Isabel', 'Fleming', 'isabel.fleming@domain.com', 1),
    (8, 'Heather', 'Jennings', 'heather.jennings@domain.com', 2),
    (9, 'Jeremy', 'Clark', 'jeremy.clark@domain.com', 2);
