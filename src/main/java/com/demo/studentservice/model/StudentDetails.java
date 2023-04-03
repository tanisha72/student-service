/**
 * 
 */
package com.demo.studentservice.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tanisha gupta
 *
 */

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class StudentDetails {

	private int rollNo;
	private String firstName;
	private String lastName;
	private String course;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private LocalDate dateOfBirth;

}
