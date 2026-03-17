
CREATE TABLE instructors (
                             instructor_id BIGSERIAL PRIMARY KEY,
                             instructor_name VARCHAR(100) NOT NULL,
                             email VARCHAR(100) UNIQUE
);


CREATE TABLE students (
                          student_id BIGSERIAL PRIMARY KEY,
                          student_name VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE,
                          phone_number VARCHAR(20)
);


CREATE TABLE courses (
                         course_id BIGSERIAL PRIMARY KEY,
                         course_name VARCHAR(100) NOT NULL,
                         description TEXT,
                         instructor_id BIGINT,

                         CONSTRAINT fk_course_instructor
                             FOREIGN KEY (instructor_id)
                                 REFERENCES instructors(instructor_id)
                                 ON DELETE SET NULL
);


CREATE TABLE student_course (
                                student_id BIGINT,
                                course_id BIGINT,

                                PRIMARY KEY (student_id, course_id),

                                CONSTRAINT fk_student
                                    FOREIGN KEY (student_id)
                                        REFERENCES students(student_id)
                                        ON DELETE CASCADE,

                                CONSTRAINT fk_course
                                    FOREIGN KEY (course_id)
                                        REFERENCES courses(course_id)
                                        ON DELETE CASCADE
);