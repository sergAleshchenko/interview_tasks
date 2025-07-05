package coding_stories.tdd;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldTest {

    @Test
    void sayHelloExceptNoon() {
        HelloWorld hello = new HelloWorld();
        LocalDateTime mockTime = LocalDateTime.of(2025,3,12,16,0);
        hello.setLocalDateTime(mockTime.truncatedTo(ChronoUnit.SECONDS));

        assertEquals("Hello World! The time is: " + outputTime(mockTime), hello.sayHello());
    }

    private String outputTime(LocalDateTime dateTime) {
        return dateTime.truncatedTo(ChronoUnit.SECONDS)
                .format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    @Test
    void sayHelloNoon() {
        HelloWorld hello = new HelloWorld();
        LocalDateTime mockTime = LocalDateTime.of(2025,3,12,12,4);
        hello.setLocalDateTime(mockTime.truncatedTo(ChronoUnit.SECONDS));

        assertEquals("Hello World! The time is: it is noon", hello.sayHello());
    }

    @Test
    void sayHelloNoonLeftBorder() {
        HelloWorld hello = new HelloWorld();
        LocalDateTime mockTime = LocalDateTime.of(2025,3,12,11,30);
        hello.setLocalDateTime(mockTime.truncatedTo(ChronoUnit.SECONDS));

        assertEquals("Hello World! The time is: it is noon", hello.sayHello());
    }

    @Test
    void sayHelloNoonRightBorder() {
        HelloWorld hello = new HelloWorld();
        LocalDateTime mockTime = LocalDateTime.of(2025,3,12,12,30);
        hello.setLocalDateTime(mockTime.truncatedTo(ChronoUnit.SECONDS));

        assertEquals("Hello World! The time is: it is noon", hello.sayHello());
    }
}