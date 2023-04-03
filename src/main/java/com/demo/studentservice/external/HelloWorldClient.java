/**
 * 
 */
package com.demo.studentservice.external;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author tanisha gupta
 *
 */
//@FeignClient(name = "${student-service.hello-world-service-name}", url = "${student-service.hello-world-url}")
@FeignClient(name = "${student-service.hello-world-service-name}")
@RibbonClient(name = "${student-service.hello-world-service-name}")
public interface HelloWorldClient {

	@GetMapping("/hello-world/{firstName}")
	public ResponseEntity<String> sayHello(@PathVariable String firstName);
}
