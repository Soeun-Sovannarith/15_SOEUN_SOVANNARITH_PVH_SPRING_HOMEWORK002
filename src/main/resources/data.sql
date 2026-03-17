
INSERT INTO instructors (instructor_name, email)
VALUES
    ('Dr. Smith', 'smith@university.com'),
    ('Prof. Johnson', 'johnson@university.com'),
    ('Dr. Brown', 'brown@university.com');


INSERT INTO students (student_name, email, phone_number)
VALUES
    ('Alice', 'alice@gmail.com', '012345678'),
    ('Bob', 'bob@gmail.com', '098765432'),
    ('Charlie', 'charlie@gmail.com', '011223344'),
    ('Diana', 'diana@gmail.com', '099887766');



INSERT INTO courses (course_name, description, instructor_id)
VALUES
    ('Database Systems', 'Learn SQL and database design', 1),
    ('Web Development', 'Frontend + Backend basics', 2),
    ('Data Structures', 'Learn algorithms and structures', 3),
    ('Operating Systems', 'Processes, memory, scheduling', 1);


UPDATE students
SET student_name = CASE student_id
                       WHEN 1 THEN 'Sok Dara'
                       WHEN 2 THEN 'Chantha Srey'
                       WHEN 3 THEN 'Vanna Sok'
                       WHEN 4 THEN 'Davy Sopheak'
                       WHEN 5 THEN 'Srey Pov'
                       WHEN 6 THEN 'Kakina'
    END
WHERE student_id IN (1,2,3,4,5,6);