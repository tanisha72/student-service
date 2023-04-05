/**
 * 
 */
package com.demo.studentservice.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.demo.studentservice.constants.ApplicationConstants;
import com.demo.studentservice.entity.Student;
import com.demo.studentservice.external.HelloWorldClient;
import com.demo.studentservice.model.StudentDetails;
import com.demo.studentservice.model.StudentRequestBody;
import com.demo.studentservice.model.StudentResponseBody;
import com.demo.studentservice.service.ManageStudentService;

/**
 * @author tanisha gupta
 *
 */

@RestController
public class StudentServiceController {

	@Autowired
	ManageStudentService studentService;

	@Autowired
	HelloWorldClient helloWorldClient;

	@GetMapping("/students")
	public ResponseEntity<StudentResponseBody> retrieveAllStudents() {
		return ResponseEntity.ok(StudentResponseBody.builder().studentList(studentService.retrieveStudents())
				.status(ApplicationConstants.SUCCESS).build());
	}

	@PostMapping("/students")
	public ResponseEntity<StudentResponseBody> createStudent(@RequestBody StudentRequestBody request) {

		Student student = studentService.createStudent(request);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{rollNo}")
				.buildAndExpand(student.getRollNo()).toUri();

		return ResponseEntity.created(location)
				.body(StudentResponseBody.builder().status(ApplicationConstants.SUCCESS).build());
	}

	@GetMapping("/students/course/{course}")
	public ResponseEntity<StudentResponseBody> retrieveStudentsByCourse(@PathVariable String course) {
		return ResponseEntity
				.ok(StudentResponseBody.builder().studentList(studentService.retrieveStudentsByCourse(course))
						.status(ApplicationConstants.SUCCESS).build());

	}

	@GetMapping("/students/{rollNo}")
	public ResponseEntity<StudentResponseBody> retrieveStudentByRollNo(@PathVariable int rollNo) {
		List<StudentDetails> list = new ArrayList<>();
		list.add(studentService.retrieveStudentByRollNo(rollNo));
		return ResponseEntity
				.ok(StudentResponseBody.builder().status(ApplicationConstants.SUCCESS).studentList(list).build());
	}

	@DeleteMapping("/students/{rollNo}")
	public ResponseEntity<StudentResponseBody> deleteStudentByRollNo(@PathVariable int rollNo) {
		studentService.deleteStudentByRollNo(rollNo);
		return ResponseEntity.ok(StudentResponseBody.builder().status(ApplicationConstants.SUCCESS).build());
	}

	@PutMapping("/students")
	public ResponseEntity<StudentResponseBody> updateStudent(@RequestBody StudentRequestBody request) {
		List<StudentDetails> list = new ArrayList<>();
		list.add(studentService.updateStudent(request));
		return ResponseEntity
				.ok(StudentResponseBody.builder().status(ApplicationConstants.SUCCESS).studentList(list).build());
	}

	@GetMapping("students/greetStudent/{firstName}")
	public ResponseEntity<String> greetStudent(@PathVariable String firstName) {
		return helloWorldClient.sayHello(firstName);
	}

}
