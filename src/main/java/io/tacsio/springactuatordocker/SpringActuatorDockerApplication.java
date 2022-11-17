package io.tacsio.springactuatordocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringActuatorDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringActuatorDockerApplication.class, args);
	}

}

@RestController
class SampleController {

	@GetMapping("/")
	public ResponseEntity<?> hello() {
		var resp = new Msg("Hello, Spring!");
		return ResponseEntity.ok(resp);
	}
}

record Msg(String value){}