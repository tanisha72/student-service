/**
 * 
 */
package com.demo.studentservice.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.demo.studentservice.exception.InexistentRollNoException;
import com.demo.studentservice.exception.NoStudentsFoundException;
import com.demo.studentservice.model.ErrorDetails;

/**
 * @author tanisha gupta
 *
 */

@RestControllerAdvice
public class StudentServiceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleOtherExceptions(Exception e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDetails.builder().status("Failed")
				.message("Unable to perform this operation at the moment").timeStamp(LocalDateTime.now()).build());
	}

	@ExceptionHandler(NoStudentsFoundException.class)
	public ResponseEntity<ErrorDetails> handleNoStudentsFoundException(NoStudentsFoundException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDetails.builder().status("Failed")
				.message("No student data present in system").timeStamp(LocalDateTime.now()).build());
	}

	@ExceptionHandler(InexistentRollNoException.class)
	public ResponseEntity<ErrorDetails> handleInexistentRollNoException(InexistentRollNoException e) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorDetails.builder().status("Failed")
				.message("No student data present in system for given roll no").timeStamp(LocalDateTime.now()).build());
	}

}
