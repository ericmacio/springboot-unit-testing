package com.luv2code.springmvc.service;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentAndGradeService {

    @Autowired
    private StudentDao studentDao;

    public void createStudent(String firstName, String lastName, String email) {
        CollegeStudent student = new CollegeStudent(firstName, lastName, email);
        student.setId(0L);
        studentDao.save(student);
    }

    public boolean checkIfStudentIsNull(Long id) {
        return studentDao.findStudentById(id).isPresent();
    }

    public void deleteStudent(Long id) {
        studentDao.deleteStudentById(id)
                .filter(i -> i>0)
                .orElseThrow();
    }

    public Iterable<CollegeStudent> getGradebook() {
        return studentDao.findAll();
    }
}
