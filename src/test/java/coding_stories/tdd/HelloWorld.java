package coding_stories.tdd;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class HelloWorld {

    private LocalDateTime dateTimeMock;

    public String sayHello() {
        return "Hello World! The time is: " + computeTime();
    }


    private String computeTime() {
        LocalDateTime targetTime = getLocalDateTime();
        boolean isNoon = isNoon(targetTime);

        if (isNoon) {
            return "it is noon";
        } else {
            return targetTime.format(DateTimeFormatter.ISO_LOCAL_TIME);
        }
    }

    private LocalDateTime getLocalDateTime() {
        return (dateTimeMock != null) ?
                dateTimeMock.truncatedTo(ChronoUnit.SECONDS) :
                LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    private boolean isNoon(LocalDateTime targetTime) {
        LocalDateTime startTime = LocalDateTime.of(
                targetTime.getYear(),
                targetTime.getMonth(),
                targetTime.getDayOfMonth(),
                11, 30);

        LocalDateTime endTime = LocalDateTime.of(
                targetTime.getYear(),
                targetTime.getMonth(),
                targetTime.getDayOfMonth(),
                12, 30);

        return (targetTime.isAfter(startTime) || targetTime.isEqual(startTime))
                && (targetTime.isBefore(endTime) || targetTime.isEqual(endTime));
    }

    void setLocalDateTime(LocalDateTime mock) {
        dateTimeMock = mock;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        System.out.println(helloWorld.sayHello());
    }
}
