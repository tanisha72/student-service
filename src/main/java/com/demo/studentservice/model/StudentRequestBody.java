/**
 * 
 */
package com.demo.studentservice.model;

import java.time.LocalDate;

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
public class StudentRequestBody {

	private String firstName;
	private String lastName;
	private LocalDate dateOfBirth;
	private String course;

}
