/**
 * 
 */
package com.demo.studentservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.studentservice.entity.Student;
import com.demo.studentservice.exception.InexistentRollNoException;
import com.demo.studentservice.exception.NoStudentsFoundException;
import com.demo.studentservice.model.StudentDetails;
import com.demo.studentservice.model.StudentRequestBody;
import com.demo.studentservice.repository.StudentRepository;

/**
 * @author tanisha gupta
 *
 */

@Service
public class ManageStudentService {

	@Autowired
	StudentRepository studentRepo;

	public List<StudentDetails> retrieveStudents() {
		List<Student> studentList = studentRepo.findAll();
		if (studentList.isEmpty()) {
			throw new NoStudentsFoundException();
		}
		List<StudentDetails> studentDetailsList = new ArrayList<>();
		for (Student s : studentList) {
			studentDetailsList.add(StudentDetails.builder().rollNo(s.getRollNo()).firstName(s.getFirstName())
					.lastName(s.getLastName()).course(s.getCourse()).build());
		}

		return studentDetailsList;
	}

	public Student createStudent(StudentRequestBody request) {

		return studentRepo.save(Student.builder().firstName(request.getFirstName()).lastName(request.getLastName())
				.dateOfBirth(request.getDateOfBirth()).course(request.getCourse()).build());

	}

	public List<StudentDetails> retrieveStudentsByCourse(String course) {
		List<Student> studentList = studentRepo.findByCourse(course);
		if (studentList.isEmpty()) {
			throw new NoStudentsFoundException();
		}
		List<StudentDetails> studentDetailsList = new ArrayList<>();
		for (Student s : studentList) {
			studentDetailsList.add(StudentDetails.builder().rollNo(s.getRollNo()).firstName(s.getFirstName())
					.lastName(s.getLastName()).course(s.getCourse()).build());
		}

		return studentDetailsList;
	}

	public StudentDetails retrieveStudentByRollNo(int rollNo) {
		Student student = studentRepo.findByRollNo(rollNo);
		if (student == null) {
			throw new InexistentRollNoException();
		}
		return StudentDetails.builder().firstName(student.getFirstName()).lastName(student.getLastName())
				.course(student.getCourse()).rollNo(student.getRollNo()).build();
	}

	public void deleteStudentByRollNo(int rollNo) {
		Student student = studentRepo.findByRollNo(rollNo);
		if (student == null) {
			throw new InexistentRollNoException();
		}
		studentRepo.deleteById(rollNo);
	}

	public StudentDetails updateStudent(StudentRequestBody request) {
		Student student = studentRepo.findByFirstNameAndLastName(request.getFirstName(), request.getLastName());
		if (student == null) {
			throw new NoStudentsFoundException();
		}
		Student savedStudent = studentRepo.save(Student.builder().rollNo(student.getRollNo())
				.firstName(request.getFirstName()).lastName(request.getLastName()).dateOfBirth(request.getDateOfBirth())
				.course(request.getCourse()).build());
		return StudentDetails.builder().firstName(savedStudent.getFirstName()).lastName(savedStudent.getLastName())
				.dateOfBirth(savedStudent.getDateOfBirth()).course(savedStudent.getCourse())
				.rollNo(savedStudent.getRollNo()).build();
	}

}
