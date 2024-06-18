package kubernetes_demo;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Retention;

/**
 * @author Sergei Aleshchenko
 */
@RestController
public class HelloWorldController {


    @RequestMapping
    public String helloWorld() {
        return "Hello from Spring Boot";
    }

    @GetMapping("/home")
    public String Jetbrains() {
        return "JetBrains";
    }

    @GetMapping("/student")
    public StudentInformation getStudent() {
        return new StudentInformation(1, "John", "Beatles");
    }
}
