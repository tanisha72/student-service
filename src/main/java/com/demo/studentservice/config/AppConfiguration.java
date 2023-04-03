/**
 * 
 */
package com.demo.studentservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author tanisha gupta
 *
 */
@Component
@ConfigurationProperties("student-service")
public class AppConfiguration {

	private String helloWorldServiceName;
	private String helloWorldUrl;

}
