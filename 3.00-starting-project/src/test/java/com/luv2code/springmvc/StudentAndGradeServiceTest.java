package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import javax.swing.text.html.Option;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradeServiceTest {

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private JdbcTemplate jdbc;

    @BeforeEach
    void setup() {
        jdbc.execute("insert into student(id, firstname, lastname, email_address) " +
                "values(1, 'Tom', 'Berry', 'tom.berry@gmail.com')");
    }

    @AfterEach
    void cleanup() {
        jdbc.execute("DELETE FROM student");
    }

    @Test
    void createStudentService() {
        String expectedEmail = "eric.macio@gmail.com";
        studentService.createStudent("Eric", "Macio", expectedEmail);
        CollegeStudent student = studentDao.findStudentByEmailAddress(expectedEmail)
                        .orElseThrow();
        assertEquals(expectedEmail, student.getEmailAddress(), "find by email");
    }

    @Test
    void isStudentNullCheck() {
        assertFalse(studentService.checkIfStudentIsNull(0L));
        assertTrue(studentService.checkIfStudentIsNull(1L));
    }

    @Test
    void deleteStudentService() {
        Long studentId = 1L;
        assertTrue(studentDao.findById(studentId).isPresent());
        studentService.deleteStudent(studentId);
        assertFalse(studentDao.findById(studentId).isPresent(), "Should return false");
    }

    @Sql("/insertData.sql")
    @Test
    void getGradebookService() {
        Iterable<CollegeStudent> iterableCollegeStudents = studentService.getGradebook();
        List<CollegeStudent> collegeStudents = new ArrayList<>();
        for(CollegeStudent student : iterableCollegeStudents)
            collegeStudents.add(student);
        assertEquals(5, collegeStudents.size());
    }

}
