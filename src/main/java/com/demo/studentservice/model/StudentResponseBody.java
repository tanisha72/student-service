/**
 * 
 */
package com.demo.studentservice.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tanisha gupta
 *
 */

@Setter
@Getter
@AllArgsConstructor
@Builder(toBuilder = true)
public class StudentResponseBody {

	private String status;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<StudentDetails> studentList;

}
