/**
 * 
 */
package com.demo.studentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.studentservice.entity.Student;

/**
 * @author tanisha gupta
 *
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByCourse(String course);

	Student findByFirstNameAndLastName(String firstName, String lastName);

	Student findByRollNo(int rollNo);

}
