package com.luv2code.springmvc.repository;

import com.luv2code.springmvc.models.CollegeStudent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentDao extends CrudRepository<CollegeStudent, Long> {
    Optional<CollegeStudent> findStudentByEmailAddress(String emailValue);
    Optional<CollegeStudent> findStudentById(Long id);
    Optional<Integer> deleteStudentById(Long id);
}
