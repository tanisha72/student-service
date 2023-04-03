/**
 * 
 */
package com.demo.studentservice.model;

import java.time.LocalDateTime;

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
public class ErrorDetails {

	private String status;
	private String message;
	private LocalDateTime timeStamp;
}
