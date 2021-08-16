package learning.elastic.api;

import java.time.LocalTime;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value="/api")
@Tag(name="Default Rest API",description="Documentation for rest api")
public class DemoController {

	
	private Logger LOG = LoggerFactory.getLogger(DemoController.class);
	
	
	@GetMapping(value="/welcome")
	@Operation(summary="welcome",description="Description for welcome API")
	public String welcome() {
		LOG.info(StringUtils.join("Hello", " this is", " Spring boot", " REST API"));
		return "Welcome to Spring Boot";
	}
	
	
	@GetMapping(value="/time")
	public String time() {
		return LocalTime.now().toString();
	}
	
	
	@GetMapping(value="/header-one")
	public String headerByAnnotation(@RequestHeader(name="User-agent") String userAgent,@RequestHeader(name="header-example",required=false) String exampleHeader) {
		return "User-Agent :"+userAgent+" ,example header value is:"+exampleHeader;
	}


	@GetMapping(value = "/header-two")
	public String headerByRequest(ServerHttpRequest request) {
		return "User-Agent :"+request.getHeaders().getValuesAsList("User-agent") +" ,example header value is:"+request.getHeaders().getValuesAsList("header-example");
	}
	
	@GetMapping("/random-error")
	public ResponseEntity<String> randomError() {
		int remainder = new Random().nextInt() % 5;
		var body = "Kibana";

		switch (remainder) {
		case 0:
			return ResponseEntity.ok().body(body);
		case 1:
		case 2:
			return ResponseEntity.badRequest().body(body);
		default:
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
		}
		
	}
}
